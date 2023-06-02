package com.store.computer_store.entities;

import com.store.computer_store.enums.FormFactor;
import com.store.computer_store.enums.ProductType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Computer extends Product {
    private FormFactor formFactor;

    private static final ProductType type = ProductType.COMPUTER;

    public Computer() {}

    public Computer(int serialNumber, String manufacturer, BigDecimal price, int count, FormFactor formFactor) {
        super(serialNumber, manufacturer, price, count, type);
        this.formFactor = formFactor;
    }
}
