package com.store.computer_store.entities;

import com.store.computer_store.enums.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Inheritance
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private int serialNumber;
    private String manufacturer;
    private BigDecimal price;
    private int count;
    private ProductType productType;

    public Product(int serialNumber, String manufacturer, BigDecimal price, int count, ProductType type) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.count = count;
        this.productType = type;
    }

    public Product() { }
}
