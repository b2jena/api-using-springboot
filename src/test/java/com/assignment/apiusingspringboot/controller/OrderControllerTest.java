package com.assignment.apiusingspringboot.controller;

import com.assignment.apiusingspringboot.model.Orders;
import com.assignment.apiusingspringboot.service.OrderService;
import com.assignment.apiusingspringboot.service.OrderServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {OrderController.class})
@ExtendWith(SpringExtension.class)
class OrderControllerTest {
    @Autowired
    private OrderController orderController;

    @MockBean
    private OrderService orderService;

    /**
     * Method under test: {@link OrderController#createOrder(Orders)}
     */
    @Test
    void testCreateOrder() throws Exception {
        Orders orders = new Orders();
        orders.setAddress("42 Main St");
        orders.setCountry("GB");
        orders.setName("Name");
        orders.setOrderId(1);
        orders.setOrderStatus("Order Status");
        orders.setProductDescription("Product Description");
        orders.setProductTitle("Dr");
        when(orderService.placeOrder(Mockito.any())).thenReturn(orders);

        Orders orders2 = new Orders();
        orders2.setAddress("42 Main St");
        orders2.setCountry("GB");
        orders2.setName("Name");
        orders2.setOrderId(1);
        orders2.setOrderStatus("Order Status");
        orders2.setProductDescription("Product Description");
        orders2.setProductTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(orders2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/createOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"orderId\":1,\"orderStatus\":\"Order Status\",\"name\":\"Name\",\"country\":\"GB\",\"address\":\"42 Main St\","
                                        + "\"productTitle\":\"Dr\",\"productDescription\":\"Product Description\"}"));
    }

    /**
     * Method under test: {@link OrderController#getData()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetData() throws IOException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new OrderController(new OrderServiceImpl())).getData();
    }

    /**
     * Method under test: {@link OrderController#getData()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetData2() throws IOException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new OrderController(mock(OrderServiceImpl.class))).getData();
    }

    /**
     * Method under test: {@link OrderController#updateOrder(Integer)}
     */
    @Test
    void testUpdateOrder() throws Exception {
        when(orderService.getOrder(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        doNothing().when(orderService).updateOrder(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/updateOrder/{orderid}", 1);
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link OrderController#updateOrder(Integer)}
     */
    @Test
    void testUpdateOrder2() throws Exception {
        Orders orders = new Orders();
        orders.setAddress("42 Main St");
        orders.setCountry("GB");
        orders.setName("?");
        orders.setOrderId(1);
        orders.setOrderStatus("?");
        orders.setProductDescription("?");
        orders.setProductTitle("Dr");

        ArrayList<Orders> ordersList = new ArrayList<>();
        ordersList.add(orders);
        when(orderService.getOrder(Mockito.<Integer>any())).thenReturn(ordersList);
        doNothing().when(orderService).updateOrder(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/updateOrder/{orderid}", 1);
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"orderId\":1,\"orderStatus\":\"?\",\"name\":\"?\",\"country\":\"GB\",\"address\":\"42 Main St\",\"productTitle\":\"Dr\""
                                        + ",\"productDescription\":\"?\"}]"));
    }

    /**
     * Method under test: {@link OrderController#updateOrder(Integer)}
     */
    @Test
    void testUpdateOrder3() throws Exception {
        Orders orders = new Orders();
        orders.setAddress("42 Main St");
        orders.setCountry("GB");
        orders.setName("?");
        orders.setOrderId(1);
        orders.setOrderStatus("?");
        orders.setProductDescription("?");
        orders.setProductTitle("Dr");

        Orders orders2 = new Orders();
        orders2.setAddress("17 High St");
        orders2.setCountry("GBR");
        orders2.setName("U");
        orders2.setOrderId(2);
        orders2.setOrderStatus("U");
        orders2.setProductDescription("U");
        orders2.setProductTitle("Mr");

        ArrayList<Orders> ordersList = new ArrayList<>();
        ordersList.add(orders2);
        ordersList.add(orders);
        when(orderService.getOrder(Mockito.<Integer>any())).thenReturn(ordersList);
        doNothing().when(orderService).updateOrder(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/updateOrder/{orderid}", 1);
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"orderId\":2,\"orderStatus\":\"U\",\"name\":\"U\",\"country\":\"GBR\",\"address\":\"17 High St\",\"productTitle\":\"Mr"
                                        + "\",\"productDescription\":\"U\"},{\"orderId\":1,\"orderStatus\":\"?\",\"name\":\"?\",\"country\":\"GB\",\"address\":\"42"
                                        + " Main St\",\"productTitle\":\"Dr\",\"productDescription\":\"?\"}]"));
    }

    /**
     * Method under test: {@link OrderController#getOrder()}
     */
    @Test
    void testGetOrder() throws Exception {
        when(orderService.getAllOrders()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/getOrder");
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link OrderController#getOrder()}
     */
    @Test
    void testGetOrder2() throws Exception {
        Orders orders = new Orders();
        orders.setAddress("42 Main St");
        orders.setCountry("GB");
        orders.setName("?");
        orders.setOrderId(1);
        orders.setOrderStatus("?");
        orders.setProductDescription("?");
        orders.setProductTitle("Dr");

        ArrayList<Orders> ordersList = new ArrayList<>();
        ordersList.add(orders);
        when(orderService.getAllOrders()).thenReturn(ordersList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/getOrder");
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"orderId\":1,\"orderStatus\":\"?\",\"name\":\"?\",\"country\":\"GB\",\"address\":\"42 Main St\",\"productTitle\":\"Dr\""
                                        + ",\"productDescription\":\"?\"}]"));
    }

    /**
     * Method under test: {@link OrderController#getOrder()}
     */
    @Test
    void testGetOrder3() throws Exception {
        Orders orders = new Orders();
        orders.setAddress("42 Main St");
        orders.setCountry("GB");
        orders.setName("?");
        orders.setOrderId(1);
        orders.setOrderStatus("?");
        orders.setProductDescription("?");
        orders.setProductTitle("Dr");

        Orders orders2 = new Orders();
        orders2.setAddress("17 High St");
        orders2.setCountry("GBR");
        orders2.setName("Name");
        orders2.setOrderId(2);
        orders2.setOrderStatus("Order Status");
        orders2.setProductDescription("Product Description");
        orders2.setProductTitle("Mr");

        ArrayList<Orders> ordersList = new ArrayList<>();
        ordersList.add(orders2);
        ordersList.add(orders);
        when(orderService.getAllOrders()).thenReturn(ordersList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/getOrder");
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"orderId\":2,\"orderStatus\":\"Order Status\",\"name\":\"Name\",\"country\":\"GBR\",\"address\":\"17 High"
                                        + " St\",\"productTitle\":\"Mr\",\"productDescription\":\"Product Description\"},{\"orderId\":1,\"orderStatus\":\"?\","
                                        + "\"name\":\"?\",\"country\":\"GB\",\"address\":\"42 Main St\",\"productTitle\":\"Dr\",\"productDescription\":\"?\"}]"));
    }
}

