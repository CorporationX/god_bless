package faang.school.godbless.BJS2_3343;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Data
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item one, Item two) {
        System.out.println("Start combining");
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Item(one.getName() + "+" + two.getName(), one.getPower() + two.getPower());
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Get item from chest");
            return new Item("Chest item", 50);
        });
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Get item from shop");
            return new Item("Shop item", 30);
        });
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " thread starts");
        Inventory inventory = new Inventory();
        CompletableFuture<Void> future = inventory.getItemFromChest()
                .thenCombine(inventory.getItemFromShop(), inventory::combineItems)
                .thenAccept(inventory::addItem);
        future.join();
        System.out.println(inventory.getItems());
    }
}
