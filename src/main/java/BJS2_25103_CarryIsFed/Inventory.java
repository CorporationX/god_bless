package BJS2_25103_CarryIsFed;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Data
public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public Item combine(Item firstItem, Item secondItem) {
        Item combinedItem = new Item(firstItem.getItemName() + " of " + secondItem.getItemName(),
                firstItem.getPower() + secondItem.getPower());
        log.info("New item in inventory! {} with power {}", combinedItem.getItemName(),
                combinedItem.getPower());
        return combinedItem;
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted!", e);
                Thread.currentThread().interrupt();
            }
            Item itemFromChest = new Item("Dagger", 10);
            log.info("New item dropped from chest! {} with power {}", itemFromChest.getItemName(),
                    itemFromChest.getPower());
            return itemFromChest;
        });
    }

    public CompletableFuture<Item> getItemFromSeller() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted!", e);
                Thread.currentThread().interrupt();
            }
            Item itemFromSeller = new Item("Daedalus", 80);
            log.info("New item bought from seller! {} with power {}", itemFromSeller.getItemName(),
                    itemFromSeller.getPower());
            return itemFromSeller;
        });
    }
}
