package com.example.whislistMangement.Dtos.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class productRequestDto {

    private String productName;
    private String prodImg;
    private String description;
    private Double price;
    private int quantity;
    private Date date;

}
