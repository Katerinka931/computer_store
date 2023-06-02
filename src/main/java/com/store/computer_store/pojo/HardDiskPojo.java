package com.store.computer_store.pojo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.store.computer_store.entities.HardDisk;
import com.store.computer_store.entities.Product;
import com.store.computer_store.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonTypeName("hardDisk")
public class HardDiskPojo extends ProductPojo {
    private int volume;

    public HardDiskPojo(long id, int serialNumber, String manufacturer, BigDecimal price, int count, int volume) {
        super(id, serialNumber, manufacturer, price, count, ProductType.HARDDISK);
        this.volume = volume;
    }

    public static Product toEntity(HardDiskPojo pojo) {
        return new HardDisk(pojo.getSerialNumber(), pojo.getManufacturer(), pojo.getPrice(), pojo.getCount(), pojo.getVolume());
    }

    public static ProductPojo fromEntity(HardDisk product) {
        return new HardDiskPojo(product.getId(), product.getSerialNumber(), product.getManufacturer(), product.getPrice(), product.getCount(), product.getVolume());
    }
}
