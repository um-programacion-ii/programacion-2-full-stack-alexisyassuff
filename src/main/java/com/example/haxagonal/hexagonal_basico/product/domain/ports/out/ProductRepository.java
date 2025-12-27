package com.example.haxagonal.hexagonal_basico.product.domain.ports.out;

import com.example.haxagonal.hexagonal_basico.product.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();
    Product save(Product product);
    Optional<Product> findById(long id);
    Optional<Product> update(Long id, Product product);
    boolean deleteById(long id);

}
