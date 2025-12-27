package com.example.haxagonal.hexagonal_basico.product.infrastructure.persistence.repository;

import com.example.haxagonal.hexagonal_basico.product.domain.model.Product;
import com.example.haxagonal.hexagonal_basico.product.domain.ports.out.ProductRepository;
import com.example.haxagonal.hexagonal_basico.product.infrastructure.persistence.entity.ProductEntity;
import com.example.haxagonal.hexagonal_basico.product.infrastructure.persistence.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaProductRepositoryAdapter implements ProductRepository {

    private final JpaProductRepository jpaRepository;
    private final ProductMapper mapper;

    @Override
    public List<Product> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = mapper.toEntity(product);
        ProductEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Product> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }
}
