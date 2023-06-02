package com.store.computer_store.entities;

import com.store.computer_store.enums.ProductType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Monitor extends Product {
    private int diagonal;

    public Monitor(int serialNumber, String manufacturer, BigDecimal price, int count, int diagonal) {
        super(serialNumber, manufacturer, price, count, ProductType.MONITOR);
        this.diagonal = diagonal;
    }

    public Monitor() {

    }
}
