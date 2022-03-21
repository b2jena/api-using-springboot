package com.assignment.apiusingspringboot.repository;
import com.assignment.apiusingspringboot.model.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<Orders, Integer> {

}
