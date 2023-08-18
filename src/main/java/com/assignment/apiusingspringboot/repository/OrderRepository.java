package com.assignment.apiusingspringboot.repository;

import com.assignment.apiusingspringboot.model.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Orders, Integer> {

}
