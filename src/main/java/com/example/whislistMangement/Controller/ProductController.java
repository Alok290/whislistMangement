package com.example.whislistMangement.Controller;

import com.example.whislistMangement.Dtos.RequestDto.productRequestDto;
import com.example.whislistMangement.Dtos.ResponseDto.wishlistResponseDto;
import com.example.whislistMangement.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addItem/{username}")
    public String addItem(@PathVariable String username, @RequestBody productRequestDto product) throws Exception{

        try{
            String Result = productService.addItemToWishlist(product, username);
            return Result;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @DeleteMapping("/deleteItem/{id}")

    public ResponseEntity deleteItemById(@PathVariable Integer id) {

        String result = productService.deleteItem(id);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-wishlist")

    public ResponseEntity getAllWishlist(@RequestParam String username)throws Exception{
        try{
            List<wishlistResponseDto> Result = productService.getWishlistByUsername(username);
            return new ResponseEntity(Result,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
