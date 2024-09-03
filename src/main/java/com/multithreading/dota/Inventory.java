package com.multithreading.dota;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    @Getter
    private final List<Item> items = new ArrayList<>();
    private  List<SuperItem> superItems;

    public Inventory(List<SuperItem> superItems) {
        this.superItems = superItems;
    }

    public void addItem(Item item) {
        if(item != null){
            items.add(item);
        }
    }

    public CompletableFuture<Item> getItem (List<Item> storage, SuperItem superItem) {
        return CompletableFuture.supplyAsync(() -> {
            return storage.stream().filter(item -> superItem.getFirstItem().equals(item) ||
                    superItem.getSecondItem().equals(item)).findFirst().get();
        });
    }

    public Item combineItems(Item first, Item second){
        SuperItem item = superItems.stream().filter(superItem ->  superItem.getFirstItem().equals(first) &&
                superItem.getSecondItem().equals(second)).findFirst().get();
        item.setPower(first.getPower() + second.getPower());
       return new Item(item.getName(), item.getPower());
    }
}
