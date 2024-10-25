package school.faang.BJS2_38828_Carry;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class GameProcess {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CompletableFuture<?>[] features =
                IntStream.rangeClosed(1, 10)
                        .mapToObj(i ->
                                inventory.getFromChest()
                                        .thenCombine(inventory.buy(), inventory::combineItems)
                                        .thenCompose(newItem -> CompletableFuture.runAsync(() -> inventory.addItem(newItem)))
                        )
                        .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(features)
                .thenRun(() -> log.info("All items have been added to the inventory!"))
                .thenRun(inventory::printItems)
                .join();
    }
}
