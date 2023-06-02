package com.store.computer_store.pojo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.store.computer_store.entities.Laptop;
import com.store.computer_store.entities.Product;
import com.store.computer_store.enums.LaptopSize;
import com.store.computer_store.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonTypeName("laptop")
public class LaptopPojo extends ProductPojo {
    private LaptopSize size;

    public LaptopPojo(long id, int serialNumber, String manufacturer, BigDecimal price, int count, LaptopSize size) {
        super(id, serialNumber, manufacturer, price, count, ProductType.LAPTOP);
        this.size = size;
    }

    public static Product toEntity(LaptopPojo pojo) {
        return new Laptop(pojo.getSerialNumber(), pojo.getManufacturer(), pojo.getPrice(), pojo.getCount(), pojo.getSize());
    }

    public static ProductPojo fromEntity(Laptop product) {
        return new LaptopPojo(product.getId(), product.getSerialNumber(), product.getManufacturer(), product.getPrice(), product.getCount(), product.getSize());
    }
}
