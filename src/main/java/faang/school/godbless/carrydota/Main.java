package faang.school.godbless.carrydota;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.getItemFromChest()
                .thenCombine(inventory.buyItemInStore(), inventory::combineItems)
                .thenCompose(
                        item -> CompletableFuture.runAsync(() -> inventory.addItem(item))
                                .thenRun(() -> System.out.println("combine item: " + item.getName()))
                ).join();
    }
}
