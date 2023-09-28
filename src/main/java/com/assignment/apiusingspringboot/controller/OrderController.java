package com.assignment.apiusingspringboot.controller;

import com.assignment.apiusingspringboot.model.LocationStatistics;
import com.assignment.apiusingspringboot.model.Orders;
import com.assignment.apiusingspringboot.model.Products;
import com.assignment.apiusingspringboot.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

// i need to remove @CrossOrigin to resolve CWE 942
@RestController
@RequestMapping("api/v1/")
@CrossOrigin(value = "*")
public class OrderController {
    private static final String ORDER_DATA_URL = "https://my-json-server.typicode.com/Ved-X/assignment/orders";
    private static final String VIRUS_DATA_URL = "https://api.rootnet.in/covid19-in/stats/latest";
    @Autowired
    OrderService orderService;
    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }

    @GetMapping("/getOrder")
    public ResponseEntity<List<Orders>> getOrder() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/getOrder/{orderId}")
    public Orders getOrderById(@PathVariable String orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/orderInformation")
    public Products[] getOrderData() throws IOException {
        JsonNode jsonNode = new ObjectMapper().readTree(new URL(ORDER_DATA_URL));

        logger.info("orderInformation...");
        ObjectMapper mapper = new ObjectMapper();

        Products[] prodStats = mapper.treeToValue(jsonNode, Products[].class);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        logger.info(gson.toJson(prodStats));
        return prodStats;
    }

    @GetMapping("/covidInformation")
    public LocationStatistics[] getCovidData() throws IOException {
        JsonNode jsonNode = new ObjectMapper().readTree(new URL(VIRUS_DATA_URL));
        JsonNode regional = jsonNode.get("data").get("regional");

        logger.info("COVID location information");
        ObjectMapper mapper = new ObjectMapper();
        LocationStatistics[] locationStatistics = mapper.treeToValue(regional, LocationStatistics[].class);
        return locationStatistics;
    }

    @PutMapping("/updateOrder/{orderId}")
    public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) {
        orderService.updateOrder(order);
        Orders updatedOrder = orderService.getOrderById(order.getOrder_id());
        return new ResponseEntity<>(updatedOrder, HttpStatus.CREATED);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders orders) {
        logger.info("started creating an order...");
        Orders saveOrder = orderService.placeOrder(orders);
        logger.info("Order saved: " + Encode.forJava(saveOrder.toString()));
        ResponseEntity<Orders> response = new ResponseEntity<>(saveOrder, HttpStatus.CREATED);
        return response;
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseEntity<Orders> deleteOrder(@PathVariable String orderId) {
        logger.info("initiating deletion of " + Encode.forJava(orderId));
        orderService.deleteById(orderId);
        logger.info("deleted: " + Encode.forJava(orderId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}