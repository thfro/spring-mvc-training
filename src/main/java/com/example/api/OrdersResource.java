package com.example.api;

import com.example.orders.Order;
import com.example.services.OrderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class OrdersResource {

    private final OrderService orderService;

    // alternativ: Einsatz von @Autowired
    public OrdersResource(OrderService orderService) {
        this.orderService = orderService;
    }

    // alternativ: List<Order> als Rückgabewert

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);

    }
}
