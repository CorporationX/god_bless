package com.multithreading.dota;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Storage {
    private final List<Item> items = new ArrayList<>();

    public void addItem (Item item) {
        if(item != null){
            items.add(item);
        }
    }
}
