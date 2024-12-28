package school.faang.sprint_4.task_50822;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private final static long SIMULATION_EXECUTION_MILLIS = 10000;

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> itemFromChest = inventory.getItemFromChest();
        CompletableFuture<Item> itemFromStore = inventory.getItemFromStore();

        CompletableFuture<Item> combinedItem = inventory.futureCombineItems(itemFromChest, itemFromStore);
        inventory.addItemToInventoryAsync(combinedItem);

        try {
            Thread.sleep(SIMULATION_EXECUTION_MILLIS);
        } catch (InterruptedException e) {
            log.error("Error message: ", e);
        }
    }
}
