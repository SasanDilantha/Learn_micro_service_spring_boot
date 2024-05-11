package com.learnspringbootmicroservice.productservice.DTO;

import java.math.BigDecimal;

public record ProductResponce(
        String productId,
        String productName,
        String productDescription,
        BigDecimal productPrice
) { }
