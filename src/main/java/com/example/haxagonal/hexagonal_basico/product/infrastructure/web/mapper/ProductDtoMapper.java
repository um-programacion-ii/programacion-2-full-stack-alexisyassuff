package com.example.haxagonal.hexagonal_basico.product.infrastructure.web.mapper;

import com.example.haxagonal.hexagonal_basico.product.domain.model.Product;
import com.example.haxagonal.hexagonal_basico.product.infrastructure.web.dto.ProductRequest;
import com.example.haxagonal.hexagonal_basico.product.infrastructure.web.dto.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {

    public Product toDomain(ProductRequest request) {
        if (request == null) {
            return null;
        }
        return new Product(null, request.getPrice(), request.getDescription());
    }

    public ProductResponse toResponse(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductResponse(product.getId(), product.getPrice(), product.getDescription());
    }

}
