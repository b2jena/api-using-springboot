package com.assignment.apiusingspringboot.repository;
import com.assignment.apiusingspringboot.model.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<Orders, UUID> {
//    APIs to be developed:
//    Create Customer
//    Create Product
//    Place Order
//    Update Order Status
//    Fetch All Orders
    Orders createCustomer(Orders orders);
    Orders createProducts(Orders orders);
    Orders save(Orders orders);
    void updateOrder(UUID orderID);
    List<Orders> findAll();
}
