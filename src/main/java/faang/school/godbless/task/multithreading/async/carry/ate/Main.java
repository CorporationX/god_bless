package faang.school.godbless.task.multithreading.async.carry.ate;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int INVENTORY_SIZE = 6;

    private static final Inventory inventory = new Inventory();

    public static void main(String[] args) {
        CompletableFuture.allOf(fullInventory().toArray(new CompletableFuture[0]))
                .thenRun(Main::printInventory)
                .join();
        log.info("End");
    }

    private static List<CompletableFuture<Void>> fullInventory() {
        return IntStream
                .range(0, INVENTORY_SIZE)
                .mapToObj(i -> CompletableFuture.runAsync(Main::addCombineItem))
                .toList();
    }

    private static void addCombineItem() {
        log.info("Start: addCombineItem() method");
        var chestItem = inventory.chestGetItem();
        var storeItem = inventory.buyItem();
        chestItem.thenCombine(storeItem, inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)))
                .join();
    }

    private static void printInventory() {
        inventory.getItems().forEach(item -> log.info("Inventory: {}", item));
    }
}
