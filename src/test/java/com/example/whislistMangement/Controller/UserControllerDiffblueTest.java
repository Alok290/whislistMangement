package com.example.whislistMangement.Controller;

import static org.mockito.Mockito.when;

import com.example.whislistMangement.Dtos.RequestDto.userRequestDto;
import com.example.whislistMangement.Dtos.ResponseDto.userResponseDto;
import com.example.whislistMangement.Enum.Gender;
import com.example.whislistMangement.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerDiffblueTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#addUser(userRequestDto)}
     */
    @Test
    void testAddUser() throws Exception {
        // Arrange
        userResponseDto buildResult = userResponseDto.builder()
                .email("jane.doe@example.org")
                .gender(Gender.MALE)
                .username("janedoe")
                .build();
        when(userService.createUser(Mockito.<userRequestDto>any())).thenReturn(buildResult);

        userRequestDto userRequestDto = new userRequestDto();
        userRequestDto.setAddress("42 Main St");
        userRequestDto.setEmail("jane.doe@example.org");
        userRequestDto.setGender(Gender.MALE);
        userRequestDto.setPassword("iloveyou");
        userRequestDto.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(userRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/sign-in")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).build().perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"address\":null,\"gender\":\"MALE\"}"));
    }

    /**
     * Method under test: {@link UserController#addUser(userRequestDto)}
     */
    @Test
    void testAddUser2() throws Exception {
        // Arrange
        when(userService.createUser(Mockito.<userRequestDto>any())).thenThrow(new Exception("foo"));

        userRequestDto userRequestDto = new userRequestDto();
        userRequestDto.setAddress("42 Main St");
        userRequestDto.setEmail("jane.doe@example.org");
        userRequestDto.setGender(Gender.MALE);
        userRequestDto.setPassword("iloveyou");
        userRequestDto.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(userRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/sign-in")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).build().perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("foo"));
    }
}
