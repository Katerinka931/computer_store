package com.store.computer_store.repositories;

import com.store.computer_store.entities.Product;
import com.store.computer_store.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByProductType(ProductType productType);
}
