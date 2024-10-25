package ru.kraiush.BJS2_38082;

import lombok.Data;

@Data
public class Order {
    private int id;
    private String status;

    public Order(int id) {
        this.id = id;
        this.status = "Created";
    }
}
