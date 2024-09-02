package com.multithreading.amazon;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Order {
    private int id;
    private String status = "Не обработан";

    public Order(int id) {
        this.id = id;
    }
}
