package Dota2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item first, Item second) {
        return new Item(first.getName() + second.getName(), first.getPower() + second.getPower());
    }

    private CompletableFuture<Item> getFromChest() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.supplyAsync(() -> new Item("Sword", 100));
    }

    private CompletableFuture<Item> getFromStore() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.supplyAsync(() -> new Item("Shield", 50));
    }

    public void combine() {
        //получаем из сундука
        CompletableFuture<Item> fromChest = getFromChest();
        //получаем из магазина и комбинируем
        fromChest.thenCombine(getFromStore(), this::combineItems)
                //добавляем в инвентарь (в отдельном потоке)
                .thenCompose(item -> CompletableFuture.runAsync(() -> addItem(item)));
    }


}
