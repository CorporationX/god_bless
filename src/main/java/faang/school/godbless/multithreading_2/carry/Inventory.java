package faang.school.godbless.multithreading_2.carry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;


public record Inventory(List<Item> items) {

    public static void main(String[] args) {
        Inventory inventory = new Inventory(new ArrayList<>());
        inventory.getFromChest().thenCombine(inventory.buy(), inventory::combine)
                .thenCompose(inventory::addItem);
        System.out.println(inventory.items);
    }

    public synchronized CompletableFuture<Void> addItem(Item item) {
        items.add(item);
        return new CompletableFuture<>();
    }

    public Item combine(Item item1, Item item2) {
        return new Item(
                item1.name() + " " + item2.name(),
                item1.power() + item2.power()
        );
    }

    public CompletableFuture<Item> getFromChest() {
        threadSleep(1000L);
        return CompletableFuture.supplyAsync(() -> {
           return new Item("Name", ThreadLocalRandom.current().nextInt(1,10));
        });
    }

    public CompletableFuture<Item> buy() {
        threadSleep(1500L);
        return CompletableFuture.supplyAsync(() -> {
            return new Item("NameFromShop", ThreadLocalRandom.current().nextInt(1, 10));
        });
    }

    private void threadSleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
