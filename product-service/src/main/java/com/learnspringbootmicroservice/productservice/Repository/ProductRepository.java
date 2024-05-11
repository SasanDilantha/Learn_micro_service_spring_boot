package com.learnspringbootmicroservice.productservice.Repository;

import com.learnspringbootmicroservice.productservice.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
