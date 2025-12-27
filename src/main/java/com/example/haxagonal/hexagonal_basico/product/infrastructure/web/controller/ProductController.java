package com.example.haxagonal.hexagonal_basico.product.infrastructure.web.controller;

import com.example.haxagonal.hexagonal_basico.product.domain.model.Product;
import com.example.haxagonal.hexagonal_basico.product.domain.ports.in.CreateProductUseCase;
import com.example.haxagonal.hexagonal_basico.product.domain.ports.in.GetAllProductsUseCase;
import com.example.haxagonal.hexagonal_basico.product.infrastructure.web.dto.ProductRequest;
import com.example.haxagonal.hexagonal_basico.product.infrastructure.web.dto.ProductResponse;
import com.example.haxagonal.hexagonal_basico.product.infrastructure.web.mapper.ProductDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final GetAllProductsUseCase getAllProductsUseCase;
    private final CreateProductUseCase createProductUseCase;
    private final ProductDtoMapper dtoMapper;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> responses = getAllProductsUseCase.getAllProducts()
                .stream()
                .map(dtoMapper::toResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        Product domainProduct = dtoMapper.toDomain(request);
        Product savedProduct = createProductUseCase.createProduct(domainProduct);
        ProductResponse response = dtoMapper.toResponse(savedProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World");
    }
}
