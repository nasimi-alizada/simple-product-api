package com.example.marketapi.controller;

import com.example.marketapi.model.Product;
import com.example.marketapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    @ResponseStatus(FOUND)
    public List<Product> getProducts() {
        return productService.getProductsService();
    }

    @GetMapping("/{id}")
    @ResponseStatus(FOUND)
    public Product getProductBy(@PathVariable("id") Integer id) {
        return productService.getProductsByIdService(id);
    }


    @PostMapping
    @ResponseStatus(CREATED)
    public void postProduct(@RequestBody Product product) {
        productService.postProductService(product);
    }

    @PutMapping("/{id}")
    public void putProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        productService.putProductService(id, product);
    }

    @PatchMapping("/{id}")
    public void patchProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        productService.patchProductService(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProductService(id);
    }

}
