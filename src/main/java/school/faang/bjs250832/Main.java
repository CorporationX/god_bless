package school.faang.bjs250832;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        System.out.println("main started");
        Inventory inventory = new Inventory();
        CompletableFuture<Item> fromChest = inventory.getFromChest();
        CompletableFuture<Item> fromShop = inventory.getFromShop();
        CompletableFuture<Void> future = fromChest.thenCombine(fromShop, inventory::combineItems)
                .thenApply(item -> {
                    System.out.println("Combined item: " + item);
                    return item;
                })
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)));
        future.join();
        System.out.println("main ended");
    }

}
