package com.assignment.apiusingspringboot.service;

import com.assignment.apiusingspringboot.model.Orders;
import com.assignment.apiusingspringboot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }
    @Override
    public Orders placeOrder(Orders orders){
        return orderRepository.save(orders);
    }

    @Override
    public List<Orders> getAllOrders() {
        return (List<Orders>)orderRepository.findAll();
    }

//    @Override
//    public List<Orders> getAllOrders(){
//        return (List<Orders>) orderRepository.findAll();
//    }
//
//    @Override
//    public void updateOrder(String orderId){
//        System.out.println("Order ID = "+orderId);
//    }
}
