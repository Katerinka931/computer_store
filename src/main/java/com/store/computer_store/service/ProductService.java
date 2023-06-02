package com.store.computer_store.service;

import com.store.computer_store.utils.Utils;
import com.store.computer_store.entities.*;
import com.store.computer_store.enums.ProductType;
import com.store.computer_store.factory.StoreFactory;
import com.store.computer_store.pojo.*;
import com.store.computer_store.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final StoreFactory storeFactory = new StoreFactory();

    public ProductPojo createProduct(ProductPojo pojo) {
        String cls = pojo.getClass().getSimpleName().toLowerCase(Locale.ROOT);
        ProductType type = storeFactory.getProductTypeByClassName(Utils.getShortClassNameByPojoClass(cls));
        Product product = storeFactory.createProduct(type, pojo);
        productRepository.save(product);
        return storeFactory.createPojo(type, product);
    }

    public ProductPojo editProduct(ProductPojo pojo, long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            String cls = optionalProduct.get().getClass().getSimpleName().toLowerCase(Locale.ROOT);
            ProductType type = storeFactory.getProductTypeByClassName(Utils.getShortClassNameByPojoClass(cls));
            Product product = optionalProduct.get();
            product = storeFactory.editProductParameter(type, pojo, product);
            ProductPojo.editProduct(product, pojo);
            productRepository.save(product);
            return storeFactory.createPojo(type, product);
        }
        return null;
    }

    public List<ProductPojo> findAllByType(String type) {
        ProductType productType = storeFactory.getProductTypeByClassName(Utils.getShortClassNameByPojoClass(type));
        List<Product> products = productRepository.findAllByProductType(productType);
        return productsToPojo(products, productType);
    }

    public ProductPojo findById(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            String cls = optionalProduct.get().getClass().getSimpleName().toLowerCase(Locale.ROOT);
            ProductType type = storeFactory.getProductTypeByClassName(Utils.getShortClassNameByPojoClass(cls));
            Product product = optionalProduct.get();
            return storeFactory.createPojo(type, product);
        }
        return null;
    }

    private List<ProductPojo> productsToPojo(List<Product> products, ProductType type) {
        List<ProductPojo> pojos = new ArrayList<>();
        for (Product product : products) {
            pojos.add(storeFactory.createPojo(type, product));
        }
        return pojos;
    }
}
