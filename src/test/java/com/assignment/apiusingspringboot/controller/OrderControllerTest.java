package com.assignment.apiusingspringboot.controller;

import com.assignment.apiusingspringboot.model.Orders;
import com.assignment.apiusingspringboot.service.OrderService;
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

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {OrderController.class})
@ExtendWith(SpringExtension.class)
class OrderControllerTest {
    @Autowired
    private OrderController orderController;

    @MockBean
    private OrderService orderService;

    /**
     * Method under test: {@link OrderController#getOrderById(String)}
     */
    @Test
    void testGetOrderById() throws Exception {
        Orders orders = new Orders();
        orders.setAddress("42 Main St");
        orders.setCountry("GB");
        orders.setCustomer("Customer");
        orders.setDate("2020-03-01");
        orders.setOrder_id("Order id");
        orders.setProduct_description("Product description");
        orders.setProduct_title("Dr");
        orders.setStatus("Status");
        when(orderService.getOrderById(Mockito.any())).thenReturn(orders);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/getOrder/{orderId}", "42");
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"order_id\":\"Order id\",\"customer\":\"Customer\",\"country\":\"GB\",\"address\":\"42 Main St\",\"product_title\":"
                                        + "\"Dr\",\"product_description\":\"Product description\",\"date\":\"2020-03-01\",\"status\":\"Status\"}"));
    }

    /**
     * Method under test: {@link OrderController#getOrderData()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrderData() throws IOException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new OrderController()).getOrderData();
    }

    /**
     * Method under test: {@link OrderController#createOrder(Orders)}
     */
    @Test
    void testCreateOrder() throws Exception {
        Orders orders = new Orders();
        orders.setAddress("42 Main St");
        orders.setCountry("GB");
        orders.setCustomer("Customer");
        orders.setDate("2020-03-01");
        orders.setOrder_id("Order id");
        orders.setProduct_description("Product description");
        orders.setProduct_title("Dr");
        orders.setStatus("Status");
        when(orderService.placeOrder(Mockito.any())).thenReturn(orders);

        Orders orders2 = new Orders();
        orders2.setAddress("42 Main St");
        orders2.setCountry("GB");
        orders2.setCustomer("Customer");
        orders2.setDate("2020-03-01");
        orders2.setOrder_id("Order id");
        orders2.setProduct_description("Product description");
        orders2.setProduct_title("Dr");
        orders2.setStatus("Status");
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
                                "{\"order_id\":\"Order id\",\"customer\":\"Customer\",\"country\":\"GB\",\"address\":\"42 Main St\",\"product_title\":"
                                        + "\"Dr\",\"product_description\":\"Product description\",\"date\":\"2020-03-01\",\"status\":\"Status\"}"));
    }

    /**
     * Method under test: {@link OrderController#getCovidData()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCovidData() throws IOException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        (new OrderController()).getCovidData();
    }

    /**
     * Method under test: {@link OrderController#updateOrder(Orders)}
     */
    @Test
    void testUpdateOrder() throws Exception {
        Orders orders = new Orders();
        orders.setAddress("42 Main St");
        orders.setCountry("GB");
        orders.setCustomer("Customer");
        orders.setDate("2020-03-01");
        orders.setOrder_id("Order id");
        orders.setProduct_description("Product description");
        orders.setProduct_title("Dr");
        orders.setStatus("Status");

        Orders orders2 = new Orders();
        orders2.setAddress("42 Main St");
        orders2.setCountry("GB");
        orders2.setCustomer("Customer");
        orders2.setDate("2020-03-01");
        orders2.setOrder_id("Order id");
        orders2.setProduct_description("Product description");
        orders2.setProduct_title("Dr");
        orders2.setStatus("Status");
        when(orderService.getOrderById(Mockito.any())).thenReturn(orders);
        when(orderService.updateOrder(Mockito.any())).thenReturn(orders2);

        Orders orders3 = new Orders();
        orders3.setAddress("42 Main St");
        orders3.setCountry("GB");
        orders3.setCustomer("Customer");
        orders3.setDate("2020-03-01");
        orders3.setOrder_id("Order id");
        orders3.setProduct_description("Product description");
        orders3.setProduct_title("Dr");
        orders3.setStatus("Status");
        String content = (new ObjectMapper()).writeValueAsString(orders3);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/updateOrder/{orderId}", "42")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"order_id\":\"Order id\",\"customer\":\"Customer\",\"country\":\"GB\",\"address\":\"42 Main St\",\"product_title\":"
                                        + "\"Dr\",\"product_description\":\"Product description\",\"date\":\"2020-03-01\",\"status\":\"Status\"}"));
    }

    /**
     * Method under test: {@link OrderController#deleteOrder(String)}
     */
    @Test
    void testDeleteOrder() throws Exception {
        doNothing().when(orderService).deleteById(Mockito.any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/deleteOrder/{orderId}",
                "42");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link OrderController#deleteOrder(String)}
     */
    @Test
    void testDeleteOrder2() throws Exception {
        doNothing().when(orderService).deleteById(Mockito.any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/deleteOrder/{orderId}",
                "42");
        requestBuilder.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
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
        orders.setCustomer("?");
        orders.setDate("2020-03-01");
        orders.setOrder_id("?");
        orders.setProduct_description("?");
        orders.setProduct_title("Dr");
        orders.setStatus("?");

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
                                "[{\"order_id\":\"?\",\"customer\":\"?\",\"country\":\"GB\",\"address\":\"42 Main St\",\"product_title\":\"Dr\",\"product"
                                        + "_description\":\"?\",\"date\":\"2020-03-01\",\"status\":\"?\"}]"));
    }

    /**
     * Method under test: {@link OrderController#getOrder()}
     */
    @Test
    void testGetOrder3() throws Exception {
        Orders orders = new Orders();
        orders.setAddress("42 Main St");
        orders.setCountry("GB");
        orders.setCustomer("?");
        orders.setDate("2020-03-01");
        orders.setOrder_id("?");
        orders.setProduct_description("?");
        orders.setProduct_title("Dr");
        orders.setStatus("?");

        Orders orders2 = new Orders();
        orders2.setAddress("17 High St");
        orders2.setCountry("GBR");
        orders2.setCustomer("Customer");
        orders2.setDate("2020/03/01");
        orders2.setOrder_id("Order id");
        orders2.setProduct_description("Product description");
        orders2.setProduct_title("Mr");
        orders2.setStatus("Status");

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
                                "[{\"order_id\":\"Order id\",\"customer\":\"Customer\",\"country\":\"GBR\",\"address\":\"17 High St\",\"product_title\""
                                        + ":\"Mr\",\"product_description\":\"Product description\",\"date\":\"2020/03/01\",\"status\":\"Status\"},{\"order_id\""
                                        + ":\"?\",\"customer\":\"?\",\"country\":\"GB\",\"address\":\"42 Main St\",\"product_title\":\"Dr\",\"product_description\""
                                        + ":\"?\",\"date\":\"2020-03-01\",\"status\":\"?\"}]"));
    }

    /**
     * Method under test: {@link OrderController#index()}
     */
    @Test
    void testIndex() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/");
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Howdy! Check out the Logs to see the output..."));
    }

    /**
     * Method under test: {@link OrderController#index()}
     */
    @Test
    void testIndex2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Howdy! Check out the Logs to see the output..."));
    }
}

