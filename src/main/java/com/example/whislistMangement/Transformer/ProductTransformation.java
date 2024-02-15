package com.example.whislistMangement.Transformer;

import com.example.whislistMangement.Dtos.RequestDto.productRequestDto;
import com.example.whislistMangement.Dtos.ResponseDto.wishlistResponseDto;
import com.example.whislistMangement.Entity.Product;

import java.util.List;

public class ProductTransformation {

    public static Product convertEntity(productRequestDto productRequest){

        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .productDescription(productRequest.getDescription())
                .dateAdded(productRequest.getDate())
                .quantity(productRequest.getQuantity())
                .prodImg(productRequest.getProdImg())
                .build();
        return product;

    }


    public static wishlistResponseDto productToWishlistResponseDto(Product product) {

        wishlistResponseDto responseDto = wishlistResponseDto.builder()

                .id(product.getId())
                .productName(product.getProductName())
                .description(product.getProductDescription())
                .quantity(product.getQuantity())
                .date(product.getDateAdded())
                .price(product.getPrice())
                .prodImg(product.getProdImg())
                .build();
        return responseDto;
    }
}
