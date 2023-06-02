package com.store.computer_store.pojo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.store.computer_store.entities.Monitor;
import com.store.computer_store.entities.Product;
import com.store.computer_store.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonTypeName("monitor")
public class MonitorPojo extends ProductPojo {
    private int diagonal;

    public MonitorPojo(long id, int serialNumber, String manufacturer, BigDecimal price, int count, int diagonal) {
        super(id, serialNumber, manufacturer, price, count, ProductType.MONITOR);
        this.diagonal = diagonal;
    }

    public static Product toEntity(MonitorPojo pojo) {
        return new Monitor(pojo.getSerialNumber(), pojo.getManufacturer(), pojo.getPrice(), pojo.getCount(), pojo.getDiagonal());
    }

    public static ProductPojo fromEntity(Monitor product) {
        return new MonitorPojo(product.getId(), product.getSerialNumber(), product.getManufacturer(), product.getPrice(), product.getCount(), product.getDiagonal());
    }
}
