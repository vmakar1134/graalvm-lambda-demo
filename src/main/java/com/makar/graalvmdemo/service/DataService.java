package com.makar.graalvmdemo.service;

import com.makar.graalvmdemo.entity.Order;
import com.makar.graalvmdemo.entity.Product;
import com.makar.graalvmdemo.mapper.UserMapper;
import com.makar.graalvmdemo.model.UserResponse;
import com.makar.graalvmdemo.repository.OrderRepository;
import com.makar.graalvmdemo.repository.ProductRepository;
import com.makar.graalvmdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataService {
    
    private final UserRepository userRepository;
    
    private final ProductRepository productRepository;
    
    private final OrderRepository orderRepository;

    private final UserMapper userMapper;


    public List<UserResponse> getAllUsers() {
        return userMapper.toResponse(userRepository.findAll());
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
