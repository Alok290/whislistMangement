package com.example.whislistMangement.Service;

import com.example.whislistMangement.Dtos.RequestDto.userRequestDto;
import com.example.whislistMangement.Dtos.ResponseDto.userResponseDto;
import com.example.whislistMangement.Dtos.ResponseDto.wishlistResponseDto;
import com.example.whislistMangement.Entity.Product;
import com.example.whislistMangement.Entity.User;
import com.example.whislistMangement.Entity.Wishlist;
import com.example.whislistMangement.Exception.UserAlreadyExist;
import com.example.whislistMangement.Exception.UserNotPresent;
import com.example.whislistMangement.Repository.UserRepository;
import com.example.whislistMangement.Transformer.ProductTransformation;
import com.example.whislistMangement.Transformer.UserTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public userResponseDto createUser(userRequestDto userRequestDto) throws Exception{

        User user = UserTransformation.convertEntity(userRequestDto);
        Optional<User>optionalUser = userRepository.findByUsername(user.getUsername());
        if(optionalUser.isPresent()){
            throw new UserAlreadyExist("the user name is already present");
        }
        userRepository.save(user);
//        user.setWishlist(null);
//        Wishlist wishlist = new Wishlist();
//        user.setWishlist(wishlist);
//        wishlist.setUser(user);
        userResponseDto response = UserTransformation.userToResponseDto(user);

        return response;

    }

    public List<wishlistResponseDto> getWishlistByUsername(String username) throws Exception {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(!optionalUser.isPresent()){
            throw new UserNotPresent("user name is invalid");
        }
        User user = optionalUser.get();
        Wishlist wishlist = user.getWishlist();
        if(wishlist==null){
            return new ArrayList<>();
        }
        List<Product> list = wishlist.getProductList();
        List<wishlistResponseDto>  responseDtoList= new ArrayList<>();
        for(Product product :list){
            wishlistResponseDto Response = ProductTransformation.productToWishlistResponseDto(product);
            responseDtoList.add(Response);
        }


        return responseDtoList;
    }
}
