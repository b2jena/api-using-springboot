package com.assignment.apiusingspringboot.service;

import com.assignment.apiusingspringboot.model.Orders;
import com.assignment.apiusingspringboot.repository.OrderRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {OrderServiceImpl.class})
@ExtendWith(SpringExtension.class)
class OrderServiceImplTest {
    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    /**
     * Method under test: {@link OrderServiceImpl#placeOrder(Orders)}
     */
    @Test
    void testPlaceOrder() {
        Orders orders = new Orders();
        orders.setAddress("42 Main St");
        orders.setCountry("GB");
        orders.setCustomer("Customer");
        orders.setDate("2020-03-01");
        orders.setOrder_id("Order id");
        orders.setProduct_description("Product description");
        orders.setProduct_title("Dr");
        orders.setStatus("Status");
        when(orderRepository.save(Mockito.any())).thenReturn(orders);

        Orders orders2 = new Orders();
        orders2.setAddress("42 Main St");
        orders2.setCountry("GB");
        orders2.setCustomer("Customer");
        orders2.setDate("2020-03-01");
        orders2.setOrder_id("Order id");
        orders2.setProduct_description("Product description");
        orders2.setProduct_title("Dr");
        orders2.setStatus("Status");
        assertSame(orders, orderServiceImpl.placeOrder(orders2));
        verify(orderRepository, atLeast(1)).save(Mockito.any());
    }

    /**
     * Method under test: {@link OrderServiceImpl#getOrderById(String)}
     */
    @Test
    void testGetOrderById() {
        Orders orders = new Orders();
        orders.setAddress("42 Main St");
        orders.setCountry("GB");
        orders.setCustomer("Customer");
        orders.setDate("2020-03-01");
        orders.setOrder_id("Order id");
        orders.setProduct_description("Product description");
        orders.setProduct_title("Dr");
        orders.setStatus("Status");
        Optional<Orders> ofResult = Optional.of(orders);
        when(orderRepository.findById(Mockito.any())).thenReturn(ofResult);
        assertSame(orders, orderServiceImpl.getOrderById("42"));
        verify(orderRepository).findById(Mockito.any());
    }

    /**
     * Method under test: {@link OrderServiceImpl#getOrderById(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetOrderById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.assignment.apiusingspringboot.service.OrderServiceImpl.getOrderById(OrderServiceImpl.java:40)
        //   See https://diff.blue/R013 to resolve this issue.

        when(orderRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        orderServiceImpl.getOrderById("42");
    }

    /**
     * Method under test: {@link OrderServiceImpl#getAllOrders()}
     */
    @Test
    void testGetAllOrders() {
        ArrayList<Orders> ordersList = new ArrayList<>();
        when(orderRepository.findAll()).thenReturn(ordersList);
        List<Orders> actualAllOrders = orderServiceImpl.getAllOrders();
        assertSame(ordersList, actualAllOrders);
        assertTrue(actualAllOrders.isEmpty());
        verify(orderRepository).findAll();
    }

    /**
     * Method under test: {@link OrderServiceImpl#getOrderByCountry(String)}
     */
    @Test
    void testGetOrderByCountry() {
        ArrayList<Orders> ordersList = new ArrayList<>();
        when(orderRepository.findByCountry(Mockito.any())).thenReturn(ordersList);
        List<Orders> actualOrderByCountry = orderServiceImpl.getOrderByCountry("GB");
        assertSame(ordersList, actualOrderByCountry);
        assertTrue(actualOrderByCountry.isEmpty());
        verify(orderRepository).findByCountry(Mockito.any());
    }

    /**
     * Method under test: {@link OrderServiceImpl#getOrderByStatus(String)}
     */
    @Test
    void testGetOrderByStatus() {
        ArrayList<Orders> ordersList = new ArrayList<>();
        when(orderRepository.findByStatus(Mockito.any())).thenReturn(ordersList);
        List<Orders> actualOrderByStatus = orderServiceImpl.getOrderByStatus("Status");
        assertSame(ordersList, actualOrderByStatus);
        assertTrue(actualOrderByStatus.isEmpty());
        verify(orderRepository).findByStatus(Mockito.any());
    }

    /**
     * Method under test: {@link OrderServiceImpl#updateOrder(Orders)}
     */
    @Test
    void testUpdateOrder() {
        Orders orders = new Orders();
        orders.setAddress("42 Main St");
        orders.setCountry("GB");
        orders.setCustomer("Customer");
        orders.setDate("2020-03-01");
        orders.setOrder_id("Order id");
        orders.setProduct_description("Product description");
        orders.setProduct_title("Dr");
        orders.setStatus("Status");
        Optional<Orders> ofResult = Optional.of(orders);

        Orders orders2 = new Orders();
        orders2.setAddress("42 Main St");
        orders2.setCountry("GB");
        orders2.setCustomer("Customer");
        orders2.setDate("2020-03-01");
        orders2.setOrder_id("Order id");
        orders2.setProduct_description("Product description");
        orders2.setProduct_title("Dr");
        orders2.setStatus("Status");
        when(orderRepository.save(Mockito.any())).thenReturn(orders2);
        when(orderRepository.findById(Mockito.any())).thenReturn(ofResult);

        Orders orderRequest = new Orders();
        orderRequest.setAddress("42 Main St");
        orderRequest.setCountry("GB");
        orderRequest.setCustomer("Customer");
        orderRequest.setDate("2020-03-01");
        orderRequest.setOrder_id("Order id");
        orderRequest.setProduct_description("Product description");
        orderRequest.setProduct_title("Dr");
        orderRequest.setStatus("Status");
        assertSame(orders2, orderServiceImpl.updateOrder(orderRequest));
        verify(orderRepository).save(Mockito.any());
        verify(orderRepository).findById(Mockito.any());
    }

    /**
     * Method under test: {@link OrderServiceImpl#updateOrder(Orders)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateOrder2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.assignment.apiusingspringboot.service.OrderServiceImpl.updateOrder(OrderServiceImpl.java:58)
        //   See https://diff.blue/R013 to resolve this issue.

        Orders orders = new Orders();
        orders.setAddress("42 Main St");
        orders.setCountry("GB");
        orders.setCustomer("Customer");
        orders.setDate("2020-03-01");
        orders.setOrder_id("Order id");
        orders.setProduct_description("Product description");
        orders.setProduct_title("Dr");
        orders.setStatus("Status");
        when(orderRepository.save(Mockito.any())).thenReturn(orders);
        when(orderRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        Orders orderRequest = new Orders();
        orderRequest.setAddress("42 Main St");
        orderRequest.setCountry("GB");
        orderRequest.setCustomer("Customer");
        orderRequest.setDate("2020-03-01");
        orderRequest.setOrder_id("Order id");
        orderRequest.setProduct_description("Product description");
        orderRequest.setProduct_title("Dr");
        orderRequest.setStatus("Status");
        orderServiceImpl.updateOrder(orderRequest);
    }

    /**
     * Method under test: {@link OrderServiceImpl#deleteById(String)}
     */
    @Test
    void testDeleteById() {
        doNothing().when(orderRepository).deleteById(Mockito.any());
        orderServiceImpl.deleteById("42");
        verify(orderRepository).deleteById(Mockito.any());
        assertTrue(orderServiceImpl.getAllOrders().isEmpty());
        assertTrue(orderServiceImpl.logger instanceof ch.qos.logback.classic.Logger);
    }
}

