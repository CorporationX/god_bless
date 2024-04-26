package faang.school.godbless.bjs2_5938;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Inventory {

    private static final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        log.info("Add item {} to inventory", item);
        items.add(item);
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync((() -> {
            try {
                log.info("Get item from chest...");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return getRandomItem();
        }));
    }

    public CompletableFuture<Item> buyItemFromShop() {
        return CompletableFuture.supplyAsync((() -> {
            try {
                log.info("Buy item in shop...");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return getRandomItem();
        }));
    }

    public Item combineItems(Item first, Item second) {
        Item combineItem = new Item(first.getName() + second.getName(), first.getPower() + second.getPower());
        log.info("Combine item: {}", combineItem);
        return combineItem;
    }

    private Item getRandomItem() {
        List<String> names = new ArrayList<>();
        names.add("Sword");
        names.add("Pike");
        names.add("Bow");
        names.add("Axe");
        return new Item(names.get(ThreadLocalRandom.current().nextInt(0, names.size())),
                ThreadLocalRandom.current().nextInt(5, 11));
    }

    public void printInventory() {
        log.info("Inventory list items:");
        items.forEach(item -> log.info(String.valueOf(item)));
    }
}
