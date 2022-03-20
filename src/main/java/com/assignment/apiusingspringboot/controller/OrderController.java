package com.assignment.apiusingspringboot.controller;

import com.assignment.apiusingspringboot.model.Orders;
import com.assignment.apiusingspringboot.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);
    private static String DATA_URL = "https://my-json-server.typicode.com/Ved-X/assignment/orders";
    private OrderService orderService;

    @GetMapping("/getOrder")
    public ResponseEntity<List<Orders>> getOrder(){
        return new ResponseEntity<List<Orders>>(orderService.getAllOrders(),HttpStatus.OK);
    }
//    public OrderStats[] getData() throws IOException{
//        JsonNode jsonNode =new ObjectMapper().readTree(new URL(DATA_URL));
//
//    }
    @PostMapping("/createOrder")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders orders){
        Orders saveOrder=orderService.placeOrder(orders);
        System.out.println(saveOrder);
        return new ResponseEntity<>(saveOrder, HttpStatus.CREATED);
    }
}
