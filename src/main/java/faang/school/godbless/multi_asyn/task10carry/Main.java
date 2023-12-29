package faang.school.godbless.multi_asyn.task10carry;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.getFromChest()
                .thenCombine(inventory.getFromShop(), inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item))).join();
    }
}
