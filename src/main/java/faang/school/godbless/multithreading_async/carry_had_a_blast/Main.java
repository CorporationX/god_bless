package faang.school.godbless.multithreading_async.carry_had_a_blast;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Main {

    private static List<Item> chest;
    private static List<Item> store;

    static {
        chest = Stream.of(
                new Item("Item_1", 1),
                new Item("Item_2", 2),
                new Item("Item_3", 3),
                new Item("Item_4", 4),
                new Item("Item_5", 5),
                new Item("Item_6", 6),
                new Item("Item_7", 7),
                new Item("Item_8", 8)
        ).toList();


        store = Stream.of(
                new Item("Item_9", 9),
                new Item("Item_10", 10),
                new Item("Item_11", 11),
                new Item("Item_12", 12),
                new Item("Item_13", 13),
                new Item("Item_14", 14),
                new Item("Item_15", 15),
                new Item("Item_16", 16)
        ).toList();

    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        System.out.println("Start");
        CompletableFuture<Item> future1 = getItemFromChest();
        CompletableFuture<Item> future2 = getItemFromStore();
        future1
                .thenCombine(future2, (item1, item2) -> combine(item1, item2))
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item))).join();

        System.out.println(inventory.getItems());

    }


    static Item combine(Item item1, Item item2) {
        return new Item(item1.getName() + "_" + item2.getName(), item1.getPower() + item2.getPower());
    }


    static CompletableFuture<Item> getItemFromChest() {
        if (chest == null || chest.isEmpty()) {
            throw new RuntimeException("Cундук пуст!");
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                return chest.get(ThreadLocalRandom.current().nextInt(0, chest.size()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }


    static CompletableFuture<Item> getItemFromStore() {
        if (store == null || store.isEmpty()) {
            throw new RuntimeException("Магазин пуст!");
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                return store.get(ThreadLocalRandom.current().nextInt(0, store.size()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }


}
