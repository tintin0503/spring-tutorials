package org.tintin.interceptorexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tintin.interceptorexample.dto.Product;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/products",
    produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
public class ProductController {

    List<Product> products = List.of(
            new Product(1001L, "iPhone 12", 1200.0),
            new Product(1002L, "iPhone 14", 300.0)
    );

    @GetMapping(value="/list")
    public ResponseEntity<List<Product>> getProducts() {
        log.info("ProductController::getProducts");

        return ResponseEntity.ok(products);
    }

    @PostMapping(value="/new")
    public ResponseEntity<Product> createProduct(
            @RequestBody Product product)throws URISyntaxException {
        products.add(product);
        return ResponseEntity.ok(product);
    }
}
