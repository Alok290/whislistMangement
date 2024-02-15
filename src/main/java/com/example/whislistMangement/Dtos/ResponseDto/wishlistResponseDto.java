package com.example.whislistMangement.Dtos.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class wishlistResponseDto {
    private Integer id;
    private String productName;
    private String prodImg;
    private String description;
    private Double price;
    private int quantity;
    private Date date;
}
