package com.example.whislistMangement.Dtos.ResponseDto;


import com.example.whislistMangement.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userResponseDto {

    private String username;
    private String email;
    private String address;
    private Gender gender;

}
