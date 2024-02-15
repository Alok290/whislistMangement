package com.example.whislistMangement.Controller;

import com.example.whislistMangement.Dtos.RequestDto.userRequestDto;
import com.example.whislistMangement.Dtos.ResponseDto.userResponseDto;
import com.example.whislistMangement.Dtos.ResponseDto.wishlistResponseDto;
import com.example.whislistMangement.Entity.Product;
import com.example.whislistMangement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/sign-in")
    public ResponseEntity addUser(@RequestBody userRequestDto userRequestDto) throws Exception{
        try{
            userResponseDto Result = userService.createUser(userRequestDto);
            return new ResponseEntity(Result, HttpStatus.ACCEPTED);

        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get-wishlist")

    public ResponseEntity getAllWishlist(@RequestParam String username)throws Exception{
        try{
            List<wishlistResponseDto> Result = userService.getWishlistByUsername(username);
            return new ResponseEntity(Result,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
