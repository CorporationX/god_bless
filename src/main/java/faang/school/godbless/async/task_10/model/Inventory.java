package faang.school.godbless.async.task_10.model;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Inventory {
    private static final long SLEEPING_TIME = 3000;
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item first, Item second) {
        return new Item(first.getName() + "-" + second.getName(), first.getPower() + second.getPower());
    }

    public CompletableFuture<Item> getItemFromChest(Item item) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(SLEEPING_TIME);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
            System.out.println("достаем из сундука " + item.getName());
            return item;
        });
    }

    public CompletableFuture<Item> buyItemFromShop(Item item) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(SLEEPING_TIME);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
            System.out.println("покупаем в магазине " + item.getName());
            return item;
        });
    }

    public void combineItemsFromChestAndShop(CompletableFuture<Item> fromChest, CompletableFuture<Item> fromShop) {
        CompletableFuture<Void> combined = fromChest.thenCombine(fromShop, this::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> {
                    addItem(item);
                    System.out.println("полученный предмет " + item + " добавлен в инвентарь");
                }));
        combined.join();
    }
}