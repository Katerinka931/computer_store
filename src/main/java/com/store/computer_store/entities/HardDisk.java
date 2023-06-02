package com.store.computer_store.entities;

import com.store.computer_store.enums.ProductType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class HardDisk extends Product {
    private int volume;

    public HardDisk(int serialNumber, String manufacturer, BigDecimal price, int count, int volume) {
        super(serialNumber, manufacturer, price, count, ProductType.HARDDISK);
        this.volume = volume;
    }

    public HardDisk() {

    }
}
