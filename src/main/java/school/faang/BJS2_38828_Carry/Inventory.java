package school.faang.BJS2_38828_Carry;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
public class Inventory {
    private static final List<String> ITEM_NAMES = Arrays.asList("Sword", "Blade", "Saber", "Rapier");
    private static final int MIN_GETTING_ITEM_TIME = 3_000;
    private static final int MAX_GETTING_ITEM_TIME = 7_000;
    private static final int MIN_ITEM_POWER = 5;
    private static final int MAX_ITEM_POWER = 30;

    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void printItems() {
        items.forEach(item -> log.info("Item {} with power {}", item.getName(), item.getPower()));
    }

    public Item combineItems(Item first, Item second) {
        String itemName = String.format("%s+%s", first.getName(), second.getName());
        int itemPower = first.getPower() + second.getPower();
        return new Item(itemName, itemPower);
    }

    public synchronized void addItem(Item item) {
        items.add(item);
    }

    public CompletableFuture<Item> getFromChest() {
        return getRandomItem();
    }

    public CompletableFuture<Item> buy() {
        return getRandomItem();
    }

    private CompletableFuture<Item> getRandomItem() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(MIN_GETTING_ITEM_TIME, MAX_GETTING_ITEM_TIME));
            } catch (InterruptedException e) {
                log.error(
                        "Thread {} was interrupted while getting a new item from the chest!",
                        Thread.currentThread().getName(), e
                );
            }
            int randomItemIndex = ThreadLocalRandom.current().nextInt(ITEM_NAMES.size());
            String randomItemName = ITEM_NAMES.get(randomItemIndex);
            int randomItemPower = ThreadLocalRandom.current().nextInt(MIN_ITEM_POWER,MAX_ITEM_POWER + 1);
            return new Item(randomItemName, randomItemPower);
        });
    }
}
