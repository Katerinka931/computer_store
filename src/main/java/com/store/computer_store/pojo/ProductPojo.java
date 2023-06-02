package com.store.computer_store.pojo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.store.computer_store.entities.Product;
import com.store.computer_store.enums.ProductType;
import jakarta.persistence.Inheritance;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = ComputerPojo.class, name = "computer"),
                @JsonSubTypes.Type(value = MonitorPojo.class, name = "monitor"),
                @JsonSubTypes.Type(value = LaptopPojo.class, name = "laptop"),
                @JsonSubTypes.Type(value = HardDiskPojo.class, name = "hardDisk")
        })
@Inheritance
public abstract class ProductPojo {
    private long id;
    private int serialNumber;
    private String manufacturer;
    private BigDecimal price;
    private int count;
    private ProductType productType;

    public ProductPojo() {
    }

    public ProductPojo(long id, int serialNumber, String manufacturer, BigDecimal price, int count, ProductType productType) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.count = count;
        this.productType = productType;
    }

    public static void editProduct(Product product, ProductPojo pojo) {
        product.setSerialNumber(pojo.getSerialNumber());
        product.setManufacturer(pojo.getManufacturer());
        product.setCount(pojo.getCount());
        product.setPrice(pojo.getPrice());
    }
}
