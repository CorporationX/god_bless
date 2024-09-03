package com.multithreading.dota;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SuperItem {
    private String name;
    private Item firstItem;
    private Item secondItem;
    private  int power;

    public SuperItem(String name, Item firstItem, Item secondItem) {
        this.name = name;
        this.firstItem = firstItem;
        this.secondItem = secondItem;
    }
}
