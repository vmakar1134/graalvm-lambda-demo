package com.makar.graalvmdemo.repository;

import com.makar.graalvmdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
