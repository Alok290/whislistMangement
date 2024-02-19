package com.example.whislistMangement.Transformer;

import com.example.whislistMangement.Dtos.RequestDto.userRequestDto;
import com.example.whislistMangement.Dtos.ResponseDto.userResponseDto;
import com.example.whislistMangement.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserTransformation {

    @Autowired
    private static PasswordEncoder passwordEncoder;
    public static User convertEntity(userRequestDto userRequestDto){
        User user = User.builder()
                .username(userRequestDto.getUsername())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .email(userRequestDto.getEmail())
                .address(userRequestDto.getAddress())
                .gender(userRequestDto.getGender())
                .build();

        return user;
    }

    public static userResponseDto userToResponseDto(User user) {

        userResponseDto Response= userResponseDto.builder()


                .username(user.getUsername())
                .email(user.getEmail())
                .address(user.getAddress())
                .gender(user.getGender())
                .build();

        return Response;
    }
}
