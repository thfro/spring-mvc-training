package com.example.web;

import com.example.errors.EntityNotFoundException;
import com.example.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class OrdersController {

    private final OrderService orderService;

    // alternativ: Einsatz von @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/orders")
    // bind Freemarker model to ModelMap
    public String viewOrderList(@ModelAttribute("model") ModelMap model) {
        var orderList = orderService.getAllOrders();
        model.addAttribute("orderList", orderList);
        return "orders";
        // throw new EntityNotFoundException("The requested entity does not exist.");
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "This message is added to all models!");
    }
}
