package school.faang.task4112;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;

class Item {
    private final String name;
    private final int power;

    public Item(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }
}

class Inventory {
    private final List<Item> items = new ArrayList<>();

    public synchronized void addItem(Item item) {
        items.add(item);
        System.out.println("Добавлен предмет: " + item.getName() + " с силой " + item.getPower());
    }

    public Item combineItems(Item item1, Item item2) {
        String combinedName = item1.getName() + " + " + item2.getName();
        int combinedPower = item1.getPower() + item2.getPower();
        return new Item(combinedName, combinedPower);
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> chestItemFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // Имитация задержки получения предмета из сундука
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return new Item("Меч из сундука", 10);
        });

        CompletableFuture<Item> shopItemFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // Имитация задержки получения предмета из магазина
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return new Item("Щит из магазина", 15);
        });

        CompletableFuture<Item> combinedItemFuture = chestItemFuture.thenCombine(shopItemFuture, (item1, item2) -> {
            return inventory.combineItems(item1, item2);
        });

        combinedItemFuture.thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item))).join();
    }
}
