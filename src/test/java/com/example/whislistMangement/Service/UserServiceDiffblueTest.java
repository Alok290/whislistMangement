package com.example.whislistMangement.Service;

import com.example.whislistMangement.Dtos.RequestDto.userRequestDto;
import com.example.whislistMangement.Enum.Gender;
import com.example.whislistMangement.Repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
class UserServiceDiffblueTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#createUser(userRequestDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateUser() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.crypto.password.PasswordEncoder.encode(java.lang.CharSequence)" because "com.example.whislistMangement.Transformer.UserTransformation.passwordEncoder" is null
        //       at com.example.whislistMangement.Transformer.UserTransformation.convertEntity(UserTransformation.java:16)
        //       at com.example.whislistMangement.Service.UserService.createUser(UserService.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        userService
                .createUser(new userRequestDto("janedoe", "iloveyou", "jane.doe@example.org", "42 Main St", Gender.MALE));
    }
}
