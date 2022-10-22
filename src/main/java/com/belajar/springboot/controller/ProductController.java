package com.belajar.springboot.controller;


import com.belajar.springboot.model.Product;
import com.belajar.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Integer id){
        return productService.getById(id);
    }
    @GetMapping
    public List<Product> getAll(){
        return productService.getAllProduct();
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id")Integer id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }
    @DeleteMapping("/{id}")
    private Map<String, Boolean> deleteProduct(@PathVariable("id")Integer id){
        return productService.deleteProduct(id);
    }
}
