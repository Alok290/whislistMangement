package com.example.whislistMangement.Service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.whislistMangement.Entity.User;
import com.example.whislistMangement.Entity.Wishlist;
import com.example.whislistMangement.Enum.Gender;
import com.example.whislistMangement.Repository.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomUserDetailService.class})
@ExtendWith(SpringExtension.class)
class CustomUserDetailServiceDiffblueTest {
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link CustomUserDetailService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        // Arrange
        Wishlist wishlist = new Wishlist();
        wishlist.setId(1);
        wishlist.setProductList(new ArrayList<>());
        wishlist.setUser(new User());

        User user = new User();
        user.setAddress("42 Main St");
        user.setEmail("jane.doe@example.org");
        user.setGender(Gender.MALE);
        user.setId(1);
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        user.setWishlist(wishlist);

        Wishlist wishlist2 = new Wishlist();
        wishlist2.setId(1);
        wishlist2.setProductList(new ArrayList<>());
        wishlist2.setUser(user);

        User user2 = new User();
        user2.setAddress("42 Main St");
        user2.setEmail("jane.doe@example.org");
        user2.setGender(Gender.MALE);
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setUsername("janedoe");
        user2.setWishlist(wishlist2);
        Optional<User> ofResult = Optional.of(user2);
        when(userRepository.findByUsername(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        UserDetails actualLoadUserByUsernameResult = customUserDetailService.loadUserByUsername("janedoe");

        // Assert
        verify(userRepository).findByUsername(eq("janedoe"));
        assertSame(user2, actualLoadUserByUsernameResult);
    }

    /**
     * Method under test: {@link CustomUserDetailService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        // Arrange
        Optional<User> emptyResult = Optional.empty();
        when(userRepository.findByUsername(Mockito.<String>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> customUserDetailService.loadUserByUsername("janedoe"));
        verify(userRepository).findByUsername(eq("janedoe"));
    }

    /**
     * Method under test: {@link CustomUserDetailService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        // Arrange
        when(userRepository.findByUsername(Mockito.<String>any())).thenThrow(new UsernameNotFoundException("invalid"));

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> customUserDetailService.loadUserByUsername("janedoe"));
        verify(userRepository).findByUsername(eq("janedoe"));
    }

    /**
     * Method under test: {@link CustomUserDetailService#passwordEncoder()}
     */
    @Test
    void testPasswordEncoder() {
        // Arrange, Act and Assert
        assertTrue(customUserDetailService.passwordEncoder() instanceof BCryptPasswordEncoder);
    }
}
