package com.store.computer_store.controller;

import com.store.computer_store.pojo.*;
import com.store.computer_store.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/test/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<ProductPojo>> findAllByType(@PathVariable String type) {
        try {
            return new ResponseEntity<>(productService.findAllByType(type), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPojo> findById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add_product")
    public ResponseEntity<ProductPojo> createProduct(@RequestBody ProductPojo pojo) {
        try {
            return new ResponseEntity<>(productService.createProduct(pojo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ProductPojo> editProduct(@RequestBody ProductPojo pojo, @PathVariable long id) {
        try {
            return new ResponseEntity<>(productService.editProduct(pojo, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
