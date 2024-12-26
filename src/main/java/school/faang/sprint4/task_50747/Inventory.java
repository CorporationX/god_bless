package school.faang.sprint4.task_50747;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Inventory {
    private static final int DELAY = 1000;

    private final List<Item> items = new ArrayList<>();

    public void addItem(@NonNull Item item) {
        items.add(item);
        log.info("{} with power {} was added to inventory", item.getName(), item.getPower());
    }

    public Item combineItems(Item first, Item second) {
        String combinedName = first.getName() + " " + second.getName() + " | combined";
        int combinedPower = first.getPower() + second.getPower();

        Item combined = new Item(combinedName, combinedPower);

        log.info("{} combined with {}. Result: {}, {}",
                first.getName(), second.getName(),
                combined.getName(), combined.getPower());

        return combined;
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Item item = new Item("Chest Item", 10);
            log.info("{} with power {} got from the chest", item.getName(), item.getPower());
            return item;
        });
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Item item = new Item("Shop item", 20);
            log.info("{} with power {} was bought from the shop", item.getName(), item.getPower());

            return item;
        });
    }

    public CompletableFuture<Void> combineTwoItems(CompletableFuture<Item> future1, CompletableFuture<Item> future2) {
        return future1.thenCombine(future2, this::combineItems)
                .thenCompose((item) -> CompletableFuture.runAsync(() -> addItem(item)));
    }

    public void printInventory() {
        items.forEach(System.out::println);
    }
}
