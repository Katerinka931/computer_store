package com.store.computer_store.factory;

import com.store.computer_store.entities.*;
import com.store.computer_store.enums.ProductType;
import com.store.computer_store.pojo.*;

public class StoreFactory {

    public Product createProduct(ProductType type, ProductPojo productPojo) {
        Product product = null;
        switch (type) {
            case COMPUTER -> product = ComputerPojo.toEntity((ComputerPojo) productPojo);

            case LAPTOP -> product = LaptopPojo.toEntity((LaptopPojo) productPojo);

            case HARDDISK -> product = HardDiskPojo.toEntity((HardDiskPojo) productPojo);

            case MONITOR -> product = MonitorPojo.toEntity((MonitorPojo) productPojo);
        }
        return product;
    }

    public Product editProductParameter(ProductType type, ProductPojo productPojo, Product product) {
        switch (type) {
            case COMPUTER -> {
                Computer newProduct = (Computer) product;
                ComputerPojo pojo = (ComputerPojo) productPojo;
                newProduct.setFormFactor(pojo.getFormFactor());
                return newProduct;
            }

            case LAPTOP -> {
                Laptop newProduct = (Laptop) product;
                LaptopPojo pojo = (LaptopPojo) productPojo;
                newProduct.setSize(pojo.getSize());
                return newProduct;
            }

            case HARDDISK -> {
                HardDisk newProduct = (HardDisk) product;
                HardDiskPojo pojo = (HardDiskPojo) productPojo;
                newProduct.setVolume(pojo.getVolume());
                return newProduct;
            }

            case MONITOR -> {
                Monitor newProduct = (Monitor) product;
                MonitorPojo pojo = (MonitorPojo) productPojo;
                newProduct.setDiagonal(pojo.getDiagonal());
                return newProduct;
            }
        }
        return product;
    }

    public ProductType getProductTypeByClassName(String str) {
        return switch (str) {
            case "computer" -> ProductType.COMPUTER;
            case "laptop" -> ProductType.LAPTOP;
            case "monitor" -> ProductType.MONITOR;
            case "harddisk" -> ProductType.HARDDISK;
            default -> null;
        };
    }

    public ProductPojo createPojo(ProductType type, Product prod) {
        ProductPojo pojo = null;
        switch (type) {
            case COMPUTER -> pojo = ComputerPojo.fromEntity((Computer) prod);

            case LAPTOP -> pojo = LaptopPojo.fromEntity((Laptop) prod);

            case MONITOR -> pojo = MonitorPojo.fromEntity((Monitor) prod);

            case HARDDISK -> pojo = HardDiskPojo.fromEntity((HardDisk) prod);
        }
        return pojo;
    }
}
