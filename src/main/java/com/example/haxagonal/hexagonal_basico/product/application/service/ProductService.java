package com.example.haxagonal.hexagonal_basico.product.application.service;

import com.example.haxagonal.hexagonal_basico.product.domain.model.Product;
import com.example.haxagonal.hexagonal_basico.product.domain.ports.in.CreateProductUseCase;
import com.example.haxagonal.hexagonal_basico.product.domain.ports.in.GetAllProductsUseCase;
import com.example.haxagonal.hexagonal_basico.product.domain.ports.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements CreateProductUseCase, GetAllProductsUseCase {

    private final ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }
}
