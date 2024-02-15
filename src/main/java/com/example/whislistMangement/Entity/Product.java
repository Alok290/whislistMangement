package com.example.whislistMangement.Entity;

import com.example.whislistMangement.WhislistMangementApplication;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.Document;
import java.util.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String productDescription;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private int quantity;

    private String prodImg;


    private Date dateAdded;

    @ManyToOne
    @JoinColumn
    private Wishlist wishlist;




}
