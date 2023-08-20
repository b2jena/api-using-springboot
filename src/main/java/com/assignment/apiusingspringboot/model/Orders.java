package com.assignment.apiusingspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orderRequest")
public class Orders {
    @Id
    private int orderId;
    private String orderStatus;
    private String name;
    private String country;
    private String address;
    private String productTitle;
    private String productDescription;
    private LocalDateTime date = LocalDateTime.now();

    @Override
    public String toString() {
        return "OrderStats{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", productTitle='" + productTitle + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}