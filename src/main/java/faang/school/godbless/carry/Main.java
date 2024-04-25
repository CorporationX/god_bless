package faang.school.godbless.carry;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int AMOUNT_THREADS = 4;

    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(AMOUNT_THREADS);
        Inventory inventory = new Inventory();

        inventory.addItem(new Item("A", 1));
        inventory.addItem(new Item("B", 2));
        inventory.addItem(new Item("C", 3));
        inventory.addItem(new Item("D", 4));

        CompletableFuture<Item> fromChest = inventory.getItemFromInventory(pool);
        CompletableFuture<Item> fromShop = inventory.buy(pool);
        fromChest.thenCombine(fromShop, inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item), pool)).join();

        pool.shutdown();

        System.out.println(fromChest.get() + ", " + fromShop.get());
        System.out.println(inventory.getItems());
    }
}
