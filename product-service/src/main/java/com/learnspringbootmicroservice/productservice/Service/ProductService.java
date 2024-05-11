package com.learnspringbootmicroservice.productservice.Service;

import com.learnspringbootmicroservice.productservice.DTO.ProductRequest;
import com.learnspringbootmicroservice.productservice.DTO.ProductResponce;
import com.learnspringbootmicroservice.productservice.Model.Product;
import com.learnspringbootmicroservice.productservice.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductRequest createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .productName(productRequest.productName())
                .productDescription(productRequest.productDescription())
                .productPrice(productRequest.productPrice())
                .build();
        productRepository.save(product);
        log.info("Product created successfully");

        return new ProductRequest(product.getProductId(), product.getProductName(), product.getProductDescription(), product.getProductPrice());
    }

    public List<ProductResponce> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponce(product.getProductId(),product.getProductName(), product.getProductDescription(), product.getProductPrice()))
                .toList();
    }
}
