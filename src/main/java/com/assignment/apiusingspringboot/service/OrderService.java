package com.assignment.apiusingspringboot.service;

import com.assignment.apiusingspringboot.model.Orders;


import java.util.List;

public interface OrderService {
    Orders placeOrder(Orders orders);
    List<Orders> getAllOrders();
//    void updateOrder(String orderID);
}
