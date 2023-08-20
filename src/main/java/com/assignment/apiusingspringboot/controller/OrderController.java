package com.assignment.apiusingspringboot.controller;

import com.assignment.apiusingspringboot.model.Orders;
import com.assignment.apiusingspringboot.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.owasp.encoder.Encode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(value = "*")
public class OrderController {
    private static final String DATA_URL = "https://my-json-server.typicode.com/Ved-X/assignment/orders";
    private final OrderService orderService;
    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/getOrder")
    public ResponseEntity<List<Orders>> getOrder() {
        Exception ex = new ArithmeticException();
        logger.debug("Log check: " + Encode.forJava(ex.toString()));
        logger.debug("Log check: " + Encode.forJava(orderService.getAllOrders().toString()));
        return new ResponseEntity<List<Orders>>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/orderInformation")
    public Orders[] getData() throws IOException {
        JsonNode jsonNode = new ObjectMapper().readTree(new URL(DATA_URL));
        JsonNode regional = jsonNode.get("data").get("regional");

        logger.info("hi, this is orderInformation");
        ObjectMapper mapper = new ObjectMapper();

        Orders[] orderStats = mapper.treeToValue(regional, Orders[].class);
        return orderStats;
    }

    @PutMapping("/updateOrder/{orderid}")
    public ResponseEntity<List<Orders>> updateOrder(@PathVariable Integer orderid) {
        orderService.updateOrder(orderid);
        List<Orders> updatedOrder = orderService.getOrder(orderid);
        return new ResponseEntity<List<Orders>>(updatedOrder, HttpStatus.OK);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders orders) {
        System.out.println("started");
        Orders saveOrder = orderService.placeOrder(orders);
        System.out.println(saveOrder);
        return new ResponseEntity<>(saveOrder, HttpStatus.CREATED);
    }
}