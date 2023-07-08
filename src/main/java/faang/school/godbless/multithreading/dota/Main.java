package faang.school.godbless.multithreading.dota;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.getFromChest()
                .thenCombine(inventory.getFromStore(), inventory::combine)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)))
                .join();
    }
}
