package com.example.whislistMangement.Dtos.RequestDto;

import com.example.whislistMangement.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userRequestDto {

    private String username;
    private String password;
    private String email;
    private String address;
    private Gender gender;


}
