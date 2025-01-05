package school.faang.task_50768;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class InventoryManager {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Void> result = inventory.getItemFromStore()
                .thenCombine(inventory.getItemFromChest(), inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> {
                    inventory.addItem(item);
                    log.info("Скомбинированный предмет {} положен в инвентарь", item.toString());
                }));

        try {
            result.get();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            log.error("Не удалось получить результат асинхронного комбинирования предметов", e);
        }
    }
}
