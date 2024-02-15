package com.example.whislistMangement.Repository;

import com.example.whislistMangement.Entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist,Integer> {
}
