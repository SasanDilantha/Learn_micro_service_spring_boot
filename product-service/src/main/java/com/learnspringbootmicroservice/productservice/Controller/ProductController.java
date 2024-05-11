package com.learnspringbootmicroservice.productservice.Controller;

import com.learnspringbootmicroservice.productservice.DTO.ProductRequest;
import com.learnspringbootmicroservice.productservice.DTO.ProductResponce;
import com.learnspringbootmicroservice.productservice.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // create the new product for system
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductRequest createProdut(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    // get all product in system
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponce> getAllProducts() {
        return productService.getAllProducts();
    }

}
