package school.faang.dotatwo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final ExecutorService EXECUTOR =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static final Inventory INVENTORY = new Inventory();
    private static final List<Item> SHOP = List.of(
            new Item("Mango", 5),
            new Item("Roshan", 25),
            new Item("Tango", 20),
            new Item("Cheese", 15),
            new Item("Raindrops", 10)
    );
    private static final List<Item> CHEST = List.of(
            new Item("Kaya", 333),
            new Item("Khanda", 444),
            new Item("Lotus Orb", 222),
            new Item("Linken's Sphere", 555),
            new Item("Mjollnir", 111)
    );
    private static final Random RANDOM = new Random();
    private static final int COUNT_OPERATIONS = 5;
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

    public static void main(String[] args) {
        try {
            List<CompletableFuture<Void>> futures = new ArrayList<>();

            for (int i = 0; i < COUNT_OPERATIONS; i++) {
                CompletableFuture<Item> futureChestItem =
                        INVENTORY.getItemOnChest(CHEST.get(RANDOM.nextInt(CHEST.size())), EXECUTOR);
                CompletableFuture<Item> futureShopItem =
                        INVENTORY.getItemOnShop(SHOP.get(RANDOM.nextInt(SHOP.size())), EXECUTOR);
                futures.add(futureChestItem
                        .thenCombineAsync(futureShopItem, INVENTORY::combineItems, EXECUTOR)
                        .thenAcceptAsync(INVENTORY::addItem, EXECUTOR));
            }
            CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new))
                    .orTimeout(TIME_EXECUTION, TIME_UNIT)
                    .join();
            INVENTORY.printInventory();
            EXECUTOR.shutdown();
        } catch (CompletionException e) {
            log.error("Execution timed out {} {}", TIME_EXECUTION, TIME_UNIT);
            EXECUTOR.shutdownNow();
        }
    }
}
