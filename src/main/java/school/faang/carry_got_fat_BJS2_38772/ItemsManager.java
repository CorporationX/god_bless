package school.faang.carry_got_fat_BJS2_38772;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class ItemsManager {
    private List<Item> chest;
    private List<Item> shop;
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        Item item1 = new Item("Black King Bar", 10);
        Item item2 = new Item("Aghanim's Scepter", 15);
        Item item3 = new Item("Divine Rapier", 330);
        Item item4 = new Item("Monkey King Bar", 70);
        Item item5 = new Item("Butterfly", 35);
        Item item6 = new Item("Heart of Tarrasque", 45);
        Item item7 = new Item("Desolator", 50);

        Inventory inventory = new Inventory(new ArrayList<>());
        ItemsManager manager = new ItemsManager(new ArrayList<>(List.of(item1, item2, item3)),
                new ArrayList<>(List.of(item4, item5, item6, item7)));

        CompletableFuture<Item> future1 = manager.getItemFromChest();
        CompletableFuture<Item> future2 = manager.getItemFromShop();

        CompletableFuture<List<Item>> result = future1.thenCombine(future2, inventory::combineItems)
                .thenCompose(item -> CompletableFuture.supplyAsync(() -> {
                    inventory.addItem(item);
                    return inventory.getItems();
                }, executor));

        System.out.println(result.join());

        executor.shutdown();
    }

    public CompletableFuture<Item> getItemFromChest() {
        int gettingTime = 3000;
        int firstItem = 0;
        return getItemFromAnySource(firstItem, chest, gettingTime);
    }

    public CompletableFuture<Item> getItemFromShop() {
        int gettingTime = 2000;
        int secondItem = 1;
        return getItemFromAnySource(secondItem, shop, gettingTime);
    }

    private CompletableFuture<Item> getItemFromAnySource(int index, List<Item> items, int time) {
        return CompletableFuture.supplyAsync(() -> {
            Item result = items.get(index);
            items.remove(index);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result;
        }, executor);
    }
}