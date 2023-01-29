package com.example.services;

import com.example.orders.Customer;
import com.example.orders.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderService {

    private static final List<Order> orders = new ArrayList<>();

    @PostConstruct
    public void init() {
        orders.add(new Order(1, new Customer("customer-234@example.org", "0170 - 123456789")));
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
}
