package school.faang.task_50881;


import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Getter
@ToString
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combine(Item firstItem, Item secondItem) {
        String combinedName = firstItem.getName() + secondItem.getName();
        int combinedPower = firstItem.getPower() + secondItem.getPower();

        log.info("Combined item: {name: {}, power: {}}", combinedName, combinedPower);
        return new Item(combinedName, combinedPower);
    }

    public CompletableFuture<Item> getFromChest() {
        log.info("Started getFromChest process");
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return new Item("Sward", 10);
        });
    }

    public CompletableFuture<Item> buy() {
        log.info("Started buy process");
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return new Item("Spear", 20);
        });
    }
}
