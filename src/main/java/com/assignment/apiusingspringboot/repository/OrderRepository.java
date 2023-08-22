package com.assignment.apiusingspringboot.repository;

import com.assignment.apiusingspringboot.model.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Orders, String> {

    List<Orders> findByCountry(String country);

    @Query("{ status : ? 0}")
    List<Orders> findByStatus(String status);
}
