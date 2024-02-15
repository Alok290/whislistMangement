package com.example.whislistMangement.Repository;

import com.example.whislistMangement.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
