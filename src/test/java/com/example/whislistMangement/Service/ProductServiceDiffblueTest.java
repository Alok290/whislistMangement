package com.example.whislistMangement.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.whislistMangement.Dtos.RequestDto.productRequestDto;
import com.example.whislistMangement.Dtos.ResponseDto.wishlistResponseDto;
import com.example.whislistMangement.Entity.Product;
import com.example.whislistMangement.Entity.User;
import com.example.whislistMangement.Entity.Wishlist;
import com.example.whislistMangement.Enum.Gender;
import com.example.whislistMangement.Exception.UserNotPresent;
import com.example.whislistMangement.Repository.ProductRepository;
import com.example.whislistMangement.Repository.UserRepository;
import com.example.whislistMangement.Repository.WishlistRepository;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductService.class})
@ExtendWith(SpringExtension.class)
class ProductServiceDiffblueTest {
    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private WishlistRepository wishlistRepository;

    @Autowired
    private ProductService productService;

    /**
     * Method under test:
     * {@link ProductService#addItemToWishlist(productRequestDto, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddItemToWishlist() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        productRequestDto productRequest = null;
        String username = "";

        // Act
        String actualAddItemToWishlistResult = this.productService.addItemToWishlist(productRequest, username);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link ProductService#deleteItem(Integer)}
     */
    @Test
    void testDeleteItem() {
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

        Product product = new Product();
        product.setDateAdded(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        product.setId(1);
        product.setPrice(10.0d);
        product.setProdImg("Prod Img");
        product.setProductDescription("Product Description");
        product.setProductName("Product Name");
        product.setQuantity(1);
        product.setWishlist(wishlist2);
        Optional<Product> ofResult = Optional.of(product);
        doNothing().when(productRepository).delete(Mockito.<Product>any());
        when(productRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act
        String actualDeleteItemResult = productService.deleteItem(1);

        // Assert
        verify(productRepository).delete(Mockito.<Product>any());
        verify(productRepository).findById(Mockito.<Integer>any());
        assertEquals("one item deleted", actualDeleteItemResult);
    }

    /**
     * Method under test: {@link ProductService#getWishlistByUsername(String)}
     */
    @Test
    void testGetWishlistByUsername() throws Exception {
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
        List<wishlistResponseDto> actualWishlistByUsername = productService.getWishlistByUsername("janedoe");

        // Assert
        verify(userRepository).findByUsername(eq("janedoe"));
        assertTrue(actualWishlistByUsername.isEmpty());
    }

    /**
     * Method under test: {@link ProductService#getWishlistByUsername(String)}
     */
    @Test
    void testGetWishlistByUsername2() throws Exception {
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

        Product product = new Product();
        product.setDateAdded(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        product.setId(1);
        product.setPrice(10.0d);
        product.setProdImg("Prod Img");
        product.setProductDescription("Product Description");
        product.setProductName("Product Name");
        product.setQuantity(1);
        product.setWishlist(wishlist2);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);

        Wishlist wishlist3 = new Wishlist();
        wishlist3.setId(1);
        wishlist3.setProductList(new ArrayList<>());
        wishlist3.setUser(new User());

        User user2 = new User();
        user2.setAddress("42 Main St");
        user2.setEmail("jane.doe@example.org");
        user2.setGender(Gender.MALE);
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setUsername("janedoe");
        user2.setWishlist(wishlist3);

        Wishlist wishlist4 = new Wishlist();
        wishlist4.setId(1);
        wishlist4.setProductList(productList);
        wishlist4.setUser(user2);

        User user3 = new User();
        user3.setAddress("42 Main St");
        user3.setEmail("jane.doe@example.org");
        user3.setGender(Gender.MALE);
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setUsername("janedoe");
        user3.setWishlist(wishlist4);
        Optional<User> ofResult = Optional.of(user3);
        when(userRepository.findByUsername(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        List<wishlistResponseDto> actualWishlistByUsername = productService.getWishlistByUsername("janedoe");

        // Assert
        verify(userRepository).findByUsername(eq("janedoe"));
        assertEquals(1, actualWishlistByUsername.size());
    }

    /**
     * Method under test: {@link ProductService#getWishlistByUsername(String)}
     */
    @Test
    void testGetWishlistByUsername3() throws Exception {
        // Arrange
        Optional<User> emptyResult = Optional.empty();
        when(userRepository.findByUsername(Mockito.<String>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(UserNotPresent.class, () -> productService.getWishlistByUsername("janedoe"));
        verify(userRepository).findByUsername(eq("janedoe"));
    }
}
