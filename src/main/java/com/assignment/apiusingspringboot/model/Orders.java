package com.assignment.apiusingspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    private int orderId;
    private String orderStatus;
    private String name;
    private String country;
    private String address;
    private String productTitle;
    private String productDescription;
    private LocalDateTime date;
}
