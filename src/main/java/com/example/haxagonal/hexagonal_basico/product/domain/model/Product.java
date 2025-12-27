package com.example.haxagonal.hexagonal_basico.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private BigDecimal price;
    private String description;

}
