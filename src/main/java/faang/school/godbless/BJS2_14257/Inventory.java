package faang.school.godbless.BJS2_14257;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Inventory {
    private final List<Item> items = new ArrayList<>();
    private static final int MIN_ITEM_POWER = 1;
    private static final int MAX_ITEM_POWER = 10;
    private static final long GET_METHOD_LATENCY = 1000L;
    private static final long BUY_METHOD_LATENCY = 2000L;
    private static final String THREAD_ERROR_MESSAGE = "{} Thread was interrupted";

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("Sword", 5));
        inventory.addItem(new Item("Axe", 7));

        CompletableFuture<Void> result = inventory.combineItems()
                .thenAccept(item -> {
                    System.out.println("Combined item: " + item);
                    inventory.addItem(item);
                });
        result.join();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public CompletableFuture<Item> combineItems() {
        return getItemFromChest().thenCombine(buyItemFromSeller(), this::combine);
    }

    private CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(GET_METHOD_LATENCY);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage() + THREAD_ERROR_MESSAGE);
                Thread.currentThread().interrupt();
            }
            return items.get(0);
        });
    }

    private CompletableFuture<Item> buyItemFromSeller() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(BUY_METHOD_LATENCY);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage() + THREAD_ERROR_MESSAGE);
                Thread.currentThread().interrupt();
            }
            return new Item("Bought item", new Random().nextInt(MIN_ITEM_POWER, MAX_ITEM_POWER));
        });
    }

    private Item combine(Item firstItem, Item secondItem) {
        return new Item(firstItem.getName() + " " + secondItem.getName(), firstItem.getPower() + secondItem.getPower());
    }
}
