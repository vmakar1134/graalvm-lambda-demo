package com.makar.graalvmdemo.service;

import com.makar.graalvmdemo.entity.Order;
import com.makar.graalvmdemo.entity.Product;
import com.makar.graalvmdemo.entity.User;
import com.makar.graalvmdemo.repository.OrderRepository;
import com.makar.graalvmdemo.repository.ProductRepository;
import com.makar.graalvmdemo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataService {
    
    private final UserRepository userRepository;
    
    private final ProductRepository productRepository;
    
    private final OrderRepository orderRepository;

    public DataService(UserRepository userRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
