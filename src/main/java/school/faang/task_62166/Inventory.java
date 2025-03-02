package school.faang.task_62166;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Inventory {
    private static final int SLEEP_TIME = 3_000;
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        log.info("Combined item {} has been added to list", item.getName());
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        Item newItem = new Item();
        newItem.setName(item1.getName() + item2.getName());
        newItem.setPower(item1.getPower() + item2.getPower());
        return newItem;
    }

    public CompletableFuture<Item> getFromChest(String name, int power) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("The item is being retrieved from the chest");
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Sleep was interrupted", e);
            }
            Item item = new Item();
            item.setName(name);
            item.setPower(power);
            return item;
        });
    }

    public CompletableFuture<Item> getFromShop(String name, int power) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("The item is being retrieved from the shop");
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Sleep was interrupted", e);
            }
            Item item = new Item();
            item.setName(name);
            item.setPower(power);
            return item;
        });
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> fromChest = inventory.getFromChest("Cristalis", 30);
        CompletableFuture<Item> fromShop = inventory.getFromShop("DemonEdge", 50);
        fromChest.thenCombine(fromShop, inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item))).join();
    }
}
