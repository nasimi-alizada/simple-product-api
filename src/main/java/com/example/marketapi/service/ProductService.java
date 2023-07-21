package com.example.marketapi.service;

import com.example.marketapi.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public List<Product> getProductsService() {

        return products;

    }

    public Product getProductsByIdService(Integer id) {
        log.info("ActionLog.getProductsByIdService.start:id{}", id);
        for (Product productID : products) {
            if (productID.getId() == id)
                return productID;
        }
        log.error("ActionLog.getProductsByIdService.end:id{}", id);
        return null;
    }

    public void postProductService(Product product) {
        products.add(product);
        log.info("ActionLog.postProductService: Product posted: Product {}", product);
    }

    public void putProductService(Integer id, Product product) {
        log.info("ActionLog.putProductService: Product updated: Id {} ,Product {}", id, product);
        for (Product productPut : products) {
            if (Objects.equals(productPut.getId(), id)) {
                products.remove(productPut.getId());
                productPut.setId(product.getId());
                productPut.setName(product.getName());
                productPut.setPrice(product.getPrice());
            }
        }
    }

    public void patchProductService(Integer id, Product product) {
        log.info("ActionLog.putProductService: Product partially updated: Id {} ,Product {}", id, product);

        for (Product productPut : products) {
            if (Objects.equals(productPut.getId(), id)) {
                productPut.setPrice(product.getPrice());
            }
        }

    }

    public void deleteProductService(Integer id) {
        log.info("ActionLog.deleteProductService : Product deleted : Id{}", id);
       products.removeIf(product->product.getId()==id);

    }


}
