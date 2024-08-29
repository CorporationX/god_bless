package faang.school.godbless.BJS2_24994;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Getter
public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combinedItem(Item item1, Item item2) {
        String newItemName = item1.getName() + item2.getName();
        int newItemPower = item1.getPower() + item2.getPower();
        return new Item(newItemName, newItemPower);
    }

    public CompletableFuture<Item> getFromBox(Item item) {
        return CompletableFuture.supplyAsync(() -> {
            sleep();
            return item;
        });
    }

    public CompletableFuture<Item> getFromShop(Item item) {
        return CompletableFuture.supplyAsync(() -> {
            sleep();
            return item;
        });
    }

    private void sleep() {
        try {
            Thread.sleep(new Random().nextInt(1000, 2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
