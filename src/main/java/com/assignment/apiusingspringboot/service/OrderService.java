package com.assignment.apiusingspringboot.service;

import com.assignment.apiusingspringboot.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Orders placeOrder(Orders orders);

    List<Orders> getAllOrders();

    void updateOrder(Integer orderID);

    List<Orders> getOrder(Integer id);
}
