package com.assignment.apiusingspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orderRequest")
public class Orders {
    @Id
    private String order_id;
    private String customer;
    private String country;
    private String address;
    private String product_title;
    private String product_description;
    private String date;
    private String status;

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", customer='" + customer + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", product_title='" + product_title + '\'' +
                ", product_description='" + product_description + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}