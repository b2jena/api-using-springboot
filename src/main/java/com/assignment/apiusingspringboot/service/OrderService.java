package com.assignment.apiusingspringboot.service;

import com.assignment.apiusingspringboot.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Orders placeOrder(Orders orders);

    List<Orders> getAllOrders();

    Orders updateOrder(Orders orders);

    Orders getOrderById(String orderID);

    void deleteById(String orderID);
}
