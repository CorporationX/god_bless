package faang.school.godbless.BJS2_24917;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public record Item(String name, int power) {
    private static final int MAX_STRENGTH = 100;
    private static final List<Item> ITEMS = List.of(
            new Item("Claymore"),
            new Item("Broadsword"),
            new Item("Staff of Wizardry"),
            new Item("Ring of Health"),
            new Item("Chainmail"),
            new Item("Magic Stick"),
            new Item("Quarterstaff"),
            new Item("Sobi Mask"),
            new Item("Belt of Strength"),
            new Item("Gloves of Haste")
    );

    public Item(String name) {
        this(name, new Random().nextInt(MAX_STRENGTH));
    }

    public static CompletableFuture<Item> combineItems(Item item1, Item item2) {
        return CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Error in thread: {}", e.getMessage());
                    }
                    log.info("Combining {} and {}", item1, item2);
                    return new Item(item1.name() + " + " + item2.name(), item1.power() + item2.power());
                });
    }

    public static CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.
                supplyAsync(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Error in thread: {}", e.getMessage());
                    }
                    log.info("Getting random item");
                    return ITEMS.get(ThreadLocalRandom.current().nextInt(ITEMS.size()));
                });
    }
}
