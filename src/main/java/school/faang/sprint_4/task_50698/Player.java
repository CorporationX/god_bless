package school.faang.sprint_4.task_50698;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Player {
    private static final int CHEST_COLLECTING_TIME = 5000;
    private static final int SHOP_COLLECTING_TIME = 1000;
    private static final Inventory inventory = new Inventory();

    public static void main(String[] args) {
        CompletableFuture<Item> firstItemFuture = CompletableFuture
                .supplyAsync(() -> collectItem("Collect item from chest",
                CHEST_COLLECTING_TIME,
                "Sword",
                15));
        CompletableFuture<Item> secondItemFuture = CompletableFuture
                .supplyAsync(() -> collectItem("Collect item from chest",
                        SHOP_COLLECTING_TIME,
                        "Fireball",
                        25));
        Item combinedItem = firstItemFuture.thenCombine(secondItemFuture,
                inventory::combineItems).join();

        inventory.addItem(combinedItem);

        System.out.println(inventory);
    }

    public static Item collectItem(@NonNull String collectionMessage,
                            int collectionTime,
                            @NonNull String itemName,
                            int itemPower) {
        try {
            Thread.sleep(collectionTime);
            log.info(collectionMessage);
            return new Item(itemName, itemPower);
        } catch (InterruptedException e) {
            log.info("Collecting interrupted");
            Thread.currentThread().interrupt();
            return null;
        }
    }
}
