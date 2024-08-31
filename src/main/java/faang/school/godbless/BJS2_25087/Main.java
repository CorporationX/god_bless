package faang.school.godbless.BJS2_25087;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Item> items = new ArrayList<>();
        Inventory inventory = new Inventory(items);

        Item item1 = new Item("Sword", 5);
        Item item2 = new Item("Spear", 3);

        CompletableFuture<Item> future1 = CompletableFuture.supplyAsync(() -> {inventory.addItem(item1); return item1;});
        CompletableFuture<Item> future2 = CompletableFuture.supplyAsync(() -> {inventory.addItem(item2); return item2;});

        CompletableFuture<Void> combineFuture = future1.thenCombine(future2, inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)));
        combineFuture.get();

        inventory.getItems().forEach(item -> System.out.println(item.getName() + " " + item.getPower()));
    }
}
