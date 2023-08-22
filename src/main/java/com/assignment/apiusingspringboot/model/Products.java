package com.assignment.apiusingspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// url: https://my-json-server.typicode.com/Ved-X/assignment/orders
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Products {
    private Integer order_id;
    private String customer;
    private String country;
    private String address;
    private String product_title;
    private String product_description;
    private String date;
    private String status;

    @Override
    public String toString() {
        return "Products{" +
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
