package com.belajar.springboot.service;

import com.belajar.springboot.model.Product;
import com.belajar.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        Product updateDataProduct=productRepository.findById(id).get();
        updateDataProduct.setDescription(product.getDescription());
        updateDataProduct.setName(product.getName());
        updateDataProduct.setImage(product.getImage());
        updateDataProduct.setPrice(product.getPrice());
        return productRepository.save(updateDataProduct);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteProduct(Integer id) {
        Product updateDataProduct=productRepository.findById(id).get();
        productRepository.delete(updateDataProduct);
        Map<String, Boolean> response =new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }
}
