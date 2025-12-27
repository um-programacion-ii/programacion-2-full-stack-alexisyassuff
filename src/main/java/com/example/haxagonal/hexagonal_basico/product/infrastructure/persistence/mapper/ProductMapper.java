package com.example.haxagonal.hexagonal_basico.product.infrastructure.persistence.mapper;

import com.example.haxagonal.hexagonal_basico.product.domain.model.Product;
import com.example.haxagonal.hexagonal_basico.product.infrastructure.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toDomain(ProductEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Product(entity.getId(), entity.getPrice(), entity.getDescription());
    }

    public ProductEntity toEntity(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductEntity(product.getId(), product.getPrice(), product.getDescription());
    }

}