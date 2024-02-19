package com.example.whislistMangement.Controller;

import static org.mockito.Mockito.when;

import com.example.whislistMangement.Dtos.RequestDto.productRequestDto;
import com.example.whislistMangement.Service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ProductController.class})
@ExtendWith(SpringExtension.class)
class ProductControllerDiffblueTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    /**
     * Method under test:
     * {@link ProductController#addItem(String, productRequestDto)}
     */
    @Test
    void testAddItem() throws Exception {
        // Arrange
        when(productService.addItemToWishlist(Mockito.<productRequestDto>any(), Mockito.<String>any()))
                .thenReturn("Add Item To Wishlist");

        productRequestDto productRequestDto = new productRequestDto();
        productRequestDto.setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        productRequestDto.setDescription("The characteristics of someone or something");
        productRequestDto.setPrice(10.0d);
        productRequestDto.setProdImg("Prod Img");
        productRequestDto.setProductName("Product Name");
        productRequestDto.setQuantity(1);
        String content = (new ObjectMapper()).writeValueAsString(productRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/addItem/{username}", "janedoe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Add Item To Wishlist"));
    }

    /**
     * Method under test:
     * {@link ProductController#addItem(String, productRequestDto)}
     */
    @Test
    void testAddItem2() throws Exception {
        // Arrange
        when(productService.addItemToWishlist(Mockito.<productRequestDto>any(), Mockito.<String>any()))
                .thenThrow(new Exception("foo"));

        productRequestDto productRequestDto = new productRequestDto();
        productRequestDto.setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        productRequestDto.setDescription("The characteristics of someone or something");
        productRequestDto.setPrice(10.0d);
        productRequestDto.setProdImg("Prod Img");
        productRequestDto.setProductName("Product Name");
        productRequestDto.setQuantity(1);
        String content = (new ObjectMapper()).writeValueAsString(productRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/addItem/{username}", "janedoe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("foo"));
    }

    /**
     * Method under test: {@link ProductController#deleteItemById(Integer)}
     */
    @Test
    void testDeleteItemById() throws Exception {
        // Arrange
        when(productService.deleteItem(Mockito.<Integer>any())).thenReturn("Delete Item");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/deleteItem/{id}", 1);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete Item"));
    }

    /**
     * Method under test: {@link ProductController#getAllWishlist(String)}
     */
    @Test
    void testGetAllWishlist() throws Exception {
        // Arrange
        when(productService.getWishlistByUsername(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get-wishlist")
                .param("username", "foo");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProductController#getAllWishlist(String)}
     */
    @Test
    void testGetAllWishlist2() throws Exception {
        // Arrange
        when(productService.getWishlistByUsername(Mockito.<String>any())).thenThrow(new Exception("foo"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get-wishlist")
                .param("username", "foo");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("foo"));
    }
}
