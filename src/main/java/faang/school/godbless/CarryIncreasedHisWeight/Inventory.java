package faang.school.godbless.CarryIncreasedHisWeight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

@AllArgsConstructor
@Getter
@Setter
public class Inventory {
    private List<Item> items;

    public CompletableFuture<Item> getItemFromInventory(Item item) {
        return CompletableFuture.supplyAsync(() -> items.get(items.indexOf(item)))
                .thenApply(v -> item); //в методе достаем заданный предмет из инвенторя
    }

    public CompletableFuture<Item> getItemFromShop(Shop shop, Item item) {
        return CompletableFuture.supplyAsync(() -> shop.getItems().get(shop.getItems().indexOf(item)))
                .thenApply(v -> item); //в методе достаем заданный предмет из магазина
    }

    public synchronized CompletableFuture<Void> addItem(Item item) {
        return CompletableFuture.runAsync(() -> addItem(item));
    }

    public synchronized CompletableFuture<Void> combineItems(Item item1, Item item2, Shop shop, String name) {
        System.out.println(item1.getName() + " и " + item2.getName() + " объеденяются в " + name);
        return CompletableFuture.supplyAsync(() -> {
                    try {
                        return getItemFromInventory(item1).get();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .thenCombine(CompletableFuture.supplyAsync(() -> {
                    try {
                        return getItemFromShop(shop, item2).get();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }), (itemInventory, itemShop) -> {
                    int totalPower = itemInventory.getPower() + itemShop.getPower();
                    Item item4 = new Item(name, totalPower);
                    return addItem(item4);
                }).thenCompose(Function.identity());
    }

    public static void main(String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(5);
        Item item1 = new Item("Bottle", 10);
        Item item2 = new Item("Ring of Protection", 20);
        Item item3 = new Item("Sange", 30);
        Item item4 = new Item("Yasha", 40);
        Item item5 = new Item("Manta Style", 50);
        Item item6 = new Item("Butterfly", 60);
        Item item7 = new Item("Daedalus", 70);
        Item item8 = new Item("Heart of Tarrasque", 80);
        Item item9 = new Item("Satanic", 90);
        Item item10 = new Item("Eye of Skadi", 100);
        List<Item> itemsInventory = List.of(item1,item2,item3,item4,item5);
        List<Item> itemsShop = List.of(item6,item7,item8,item9,item10);
        Inventory inventory = new Inventory(itemsInventory);
        Shop shop = new Shop(itemsShop);
        inventory.combineItems(item1,item5,shop,"Sabre");
    }
}
