package com.example.whislistMangement.Service;

import com.example.whislistMangement.Dtos.RequestDto.productRequestDto;
import com.example.whislistMangement.Entity.Product;
import com.example.whislistMangement.Entity.User;
import com.example.whislistMangement.Entity.Wishlist;
import com.example.whislistMangement.Exception.UserNotPresent;
import com.example.whislistMangement.Repository.ProductRepository;
import com.example.whislistMangement.Repository.UserRepository;
import com.example.whislistMangement.Repository.WishlistRepository;
import com.example.whislistMangement.Transformer.ProductTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private ProductRepository productRepository;
    public String addItemToWishlist(productRequestDto productRequest, String username)throws Exception{

        Product product = ProductTransformation.convertEntity(productRequest);
        Optional<User> optionalUser=  userRepository.findByUsername(username);
        if(!optionalUser.isPresent()){
            throw new UserNotPresent("this user name is not valid");
        }
        User user  =optionalUser.get();

//        Wishlist wishlist = user.getWishlist();
        if(user.getWishlist()==null){
            Wishlist wishlist = new Wishlist();
            user.setWishlist(wishlist);
//            throw new RuntimeException("wishlist is null");
        }
        Wishlist wishlist = user.getWishlist();

      if(wishlist.getProductList()==null){
          List<Product> products = new ArrayList<>();
          wishlist.setProductList(products);
      }

       wishlist.getProductList().add(product);
       product.setWishlist(wishlist);

       wishlist.setUser(user);

//        wishlistRepository.save(wishlist);

        userRepository.save(user);



        return "Your item has been save as item id"+product.getId();

    }

    public String deleteItem(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        Product product = optionalProduct.get();
        productRepository.delete(product);
        return "one item deleted";
    }
}
