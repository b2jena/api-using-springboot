package com.assignment.apiusingspringboot.service;

import com.assignment.apiusingspringboot.model.Orders;
import com.assignment.apiusingspringboot.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {OrderServiceImpl.class})
@ExtendWith(SpringExtension.class)
class OrderServiceImplTest {
    @MockBean
    private MongoTemplate mongoTemplate;

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
        orders.setName("Name");
        orders.setOrderId(1);
        orders.setOrderStatus("Order Status");
        orders.setProductDescription("Product Description");
        orders.setProductTitle("Dr");
        when(orderRepository.save(Mockito.any())).thenReturn(orders);

        Orders orders2 = new Orders();
        orders2.setAddress("42 Main St");
        orders2.setCountry("GB");
        orders2.setName("Name");
        orders2.setOrderId(1);
        orders2.setOrderStatus("Order Status");
        orders2.setProductDescription("Product Description");
        orders2.setProductTitle("Dr");
        assertSame(orders, orderServiceImpl.placeOrder(orders2));
        verify(orderRepository, atLeast(1)).save(Mockito.any());
    }

    /**
     * Method under test: {@link OrderServiceImpl#getOrder(Integer)}
     */
    @Test
    void testGetOrder() {
        ArrayList<Orders> ordersList = new ArrayList<>();
        when(mongoTemplate.find(Mockito.any(), Mockito.<Class<Orders>>any())).thenReturn(ordersList);
        List<Orders> actualOrder = orderServiceImpl.getOrder(1);
        assertSame(ordersList, actualOrder);
        assertTrue(actualOrder.isEmpty());
        verify(mongoTemplate).find(Mockito.any(), Mockito.<Class<Orders>>any());
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
     * Method under test: {@link OrderServiceImpl#updateOrder(Integer)}
     */
    @Test
    void testUpdateOrder() {
        when(mongoTemplate.upsert(Mockito.any(), Mockito.any(), Mockito.<Class<Object>>any()))
                .thenReturn(null);
        orderServiceImpl.updateOrder(1);
        verify(mongoTemplate).upsert(Mockito.any(), Mockito.any(), Mockito.<Class<Object>>any());
    }
}

