package com.learnspringbootmicroservice.productservice.DTO;

import java.math.BigDecimal;

public record ProductRequest(
        String productId,
        String productName,
        String productDescription,
        BigDecimal productPrice
) { }
