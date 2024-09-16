
package com.makar.graalvmdemo.controller;

import com.makar.graalvmdemo.entity.Order;
import com.makar.graalvmdemo.entity.Product;
import com.makar.graalvmdemo.entity.User;
import com.makar.graalvmdemo.service.DataService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DataController {
    
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return dataService.getAllUsers();
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return dataService.getAllProducts();
    }

    @Transactional
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return dataService.getAllOrders();
    }

    @Transactional
    @GetMapping("/users/{userId}/orders")
    public List<Order> getOrdersByUserId(@PathVariable Long userId) {
        return dataService.getOrdersByUserId(userId);
    }
}
