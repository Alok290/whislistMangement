package com.example.whislistMangement.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wishlist {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;


    @OneToOne
    @JoinColumn
    private User user;


    @JsonBackReference
    @OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL)
    List<Product> productList = new ArrayList<>();




}
