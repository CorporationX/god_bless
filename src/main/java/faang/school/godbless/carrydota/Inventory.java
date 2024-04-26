package faang.school.godbless.carrydota;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Inventory {
    private final List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item first, Item second) {
        Item item = new Item();
        item.setName(first.getName() + " " + second.getName());
        item.setPower(first.getPower() + second.getPower());
        return item;
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            waitFewSeconds(2);
            return new Item("Basil", 5);
        });
    }

    public CompletableFuture<Item> buyItemInStore() {
        return CompletableFuture.supplyAsync(() -> {
            waitFewSeconds(1);
            return new Item("Mask of Madness", 20);
        });
    }

    private void waitFewSeconds(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
