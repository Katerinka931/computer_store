package com.store.computer_store.pojo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.store.computer_store.entities.Computer;
import com.store.computer_store.entities.Product;
import com.store.computer_store.enums.FormFactor;
import com.store.computer_store.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@JsonTypeName("computer")
public class ComputerPojo extends ProductPojo {
    private FormFactor formFactor;

    public ComputerPojo() {
    }

    public ComputerPojo(long id, int serialNumber, String manufacturer, BigDecimal price, int count, FormFactor formFactor) {
        super(id, serialNumber, manufacturer, price, count, ProductType.COMPUTER);
        this.formFactor = formFactor;
    }

//    @Override
    public static Product toEntity(ComputerPojo pojo) {
        return new Computer(pojo.getSerialNumber(), pojo.getManufacturer(), pojo.getPrice(), pojo.getCount(), pojo.getFormFactor());
    }

//    @Override
    public static ComputerPojo fromEntity(Computer product) {
        return new ComputerPojo(product.getId(), product.getSerialNumber(), product.getManufacturer(), product.getPrice(), product.getCount(), product.getFormFactor());
    }
}
