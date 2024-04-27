package faang.school.godbless.FatCarry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_OPERATIONS = 10;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        Inventory inventory = new Inventory(pool);

        List<Item> chest = getChest();
        List<Item> shop = getShop();

        for (int i = 0; i < NUM_OPERATIONS; i++) {
            inventory.getFromChest(chest)
                    .thenCombine(inventory.buyFromShop(shop), inventory::combineItems)
                    .thenCompose((item) -> CompletableFuture.runAsync(() -> {
                        inventory.addItem(item);
                        System.out.println("New item added: " + item);
                    }));
        }

        pool.shutdown();
    }

    private static List<Item> getChest() {
        List<Item> chest = new ArrayList<>();
        chest.add(new Item("Monkey King Bar", 25));
        chest.add(new Item("Assault Cuirass", 20));
        chest.add(new Item("Radiance", 35));
        chest.add(new Item("Shiva's Guard", 25));
        chest.add(new Item("Aghanim's Scepter", 40));
        return chest;
    }

    private static List<Item> getShop() {
        List<Item> shop = new ArrayList<>();
        shop.add(new Item("Power Treads", 25));
        shop.add(new Item("Manta Style", 15));
        shop.add(new Item("Black King Bar", 30));
        shop.add(new Item("Diffusal Blade", 10));
        shop.add(new Item("Eye of Skadi", 20));
        return shop;
    }
}
