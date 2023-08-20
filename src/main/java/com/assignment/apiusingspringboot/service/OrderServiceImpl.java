package com.assignment.apiusingspringboot.service;

import com.assignment.apiusingspringboot.model.Orders;
import com.assignment.apiusingspringboot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public OrderServiceImpl() {
    }

    @Override
    public Orders placeOrder(Orders orders) {
        try {
//            orders.setDate(LocalDateTime.now());
//            System.out.println(orders);
            orderRepository.save(orders);
            System.out.println("saved");
        } catch (Exception e) {
            System.out.println(e);
        }
        return orderRepository.save(orders);
    }

    @Override
    public List<Orders> getOrder(Integer id) {
        Query query = new Query();
        query.addCriteria(
                Criteria
                        .where("orderId")
                        .is(id)
        );
        List<Orders> order = mongoTemplate.find(query, Orders.class);
        return order;
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void updateOrder(Integer orderId) {
        Query query = new Query(Criteria.where("orderId").is(orderId));
        System.out.println("Order ID = " + orderId);
        Update updateQuery = new Update();
        updateQuery.set("orderStatus", "Delivered");
        mongoTemplate.upsert(query, updateQuery, Orders.class);
    }
}