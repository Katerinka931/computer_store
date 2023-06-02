package com.store.computer_store.entities;

import com.store.computer_store.enums.LaptopSize;
import com.store.computer_store.enums.ProductType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Laptop extends Product {
    private LaptopSize size;

    public Laptop(int serialNumber, String manufacturer, BigDecimal price, int count, LaptopSize size) {
        super(serialNumber, manufacturer, price, count, ProductType.LAPTOP);
        this.size = size;
    }

    public Laptop() {

    }
}
