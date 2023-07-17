package faang.school.godbless.multithreading.dota;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Inventory {
    private final List<Item> items;
    private final Random random;
    private final String[] chestItems;
    private final String[] storeItems;

    public Inventory() {
        items = new ArrayList<>();
        random = new Random();
        chestItems = new String[]{"Sange", "Yasha", "Kaya", "Aghanim"};
        storeItems = new String[]{"Sword", "Hyperstone", "Vladimir", "Boots"};
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println(item + " added to inventory");
    }

    public Item combine(Item item1, Item item2) {
        return new Item(
                item1.getName() + "-" + item2.getName(),
                item1.getPower() + item2.getPower()
        );
    }

    public CompletableFuture<Item> getFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            return new Item(
                    chestItems[random.nextInt(chestItems.length)],
                    random.nextInt(100, 500)
            );
        });
    }

    public CompletableFuture<Item> getFromStore() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            return new Item(
                    storeItems[random.nextInt(storeItems.length)],
                    random.nextInt(500, 1000)
            );
        });
    }
}
