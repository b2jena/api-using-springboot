package com.assignment.apiusingspringboot;

import com.assignment.apiusingspringboot.service.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ApiUsingSpringbootApplicationTest {
    /**
     * Method under test: {@link ApiUsingSpringbootApplication#orderService()}
     */
    @Test
    void testOrderService() {
        assertTrue((new ApiUsingSpringbootApplication()).orderService() instanceof OrderServiceImpl);
    }
}

