package com.assignment.apiusingspringboot.service;

import com.assignment.apiusingspringboot.model.Orders;
import com.assignment.apiusingspringboot.repository.OrderRepository;
import org.owasp.encoder.Encode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderRepository orderRepository;
    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    // CRUD operation

    public OrderServiceImpl() {
    }

    // create
    public Orders placeOrder(Orders orders) {
        try {
            orders.setOrder_id(UUID.randomUUID().toString().split("-")[0]);
            orderRepository.save(orders);
            logger.info("order saved: " + orders);
        } catch (Exception e) {
            logger.error(Encode.forJava(e.getMessage()));
        }
        return orderRepository.save(orders);
    }

    // read
    public Orders getOrderById(String id) {
        return orderRepository.findById(id).get();
    }

    // read all
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    // read using country
    public List<Orders> getOrderByCountry(String country) {
        return orderRepository.findByCountry(country);
    }

    public List<Orders> getOrderByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    // update
    public Orders updateOrder(Orders orderRequest) {
        Orders existingOrder = orderRepository.findById(orderRequest.getOrder_id()).get();
        existingOrder.setCustomer(orderRequest.getCustomer());
        existingOrder.setCountry(orderRequest.getCountry());
        existingOrder.setAddress(orderRequest.getAddress());
        existingOrder.setProduct_title(orderRequest.getProduct_title());
        existingOrder.setProduct_description(orderRequest.getProduct_description());
        existingOrder.setDate(orderRequest.getDate());
        existingOrder.setStatus(orderRequest.getStatus());
        return orderRepository.save(existingOrder);
    }

    // delete
    public void deleteById(String orderId) {
        orderRepository.deleteById(orderId);
    }
}