package com.belajar.springboot.service;

import com.belajar.springboot.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Product addProduct(Product product);
    Product getById(Integer id);
    Product updateProduct(Integer id, Product product);
    List<Product> getAllProduct();
    Map<String, Boolean> deleteProduct(Integer id);
}
