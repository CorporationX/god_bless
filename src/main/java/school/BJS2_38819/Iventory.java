package school.BJS2_38819;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Iventory {

    private List<Item> items;

    public Iventory(List<Item> items) {
        this.items = items;
    }

    public synchronized void addItem(Item item) {
        items.add(item);
    }

    public CompletableFuture<Item> combineItems(CompletableFuture<Item> item1, CompletableFuture<Item> item2) {
        System.out.println("Предмет для комбинирования 1: " + item1.join().getName());
        System.out.println("Предмет для комбинирования 2: " + item2.join().getName());
        return item1.thenCombine(item2, (x, y) -> new Item("Супер пупер крутетсткая штука", x.getPower() + y.getPower()));
    }

    public void addNewItem(CompletableFuture<Item> newItem) {
        newItem.thenCompose(item -> CompletableFuture.runAsync(() -> addItem(item))).join();
        System.out.println("Добавлен предмет: " + newItem.join().getName());
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                return new Item("Рапира", 10);
            }
        });
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                return new Item("Аегис", 45);
            }
        });
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

}