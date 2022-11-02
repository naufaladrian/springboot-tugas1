package com.belajar.springboot.repository;

import com.belajar.springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product a order by a.created_at desc", nativeQuery = true)
    List<Product> findAllByCreatedAtDesc();
}
