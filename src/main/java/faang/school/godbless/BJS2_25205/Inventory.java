package faang.school.godbless.BJS2_25205;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItems(Item item) {
        items.add(item);
        System.out.println("Добавлен предмет в инвентарь: " + item);
    }

    public Item combine(Item item1, Item item2) {
        Item combinedItem = new Item(item1.getName() + item2.getName(), item1.getPower() + item2.getPower());
        System.out.println("Скрафтили: " + combinedItem);
        return combinedItem;
    }

    public CompletableFuture<Item> getFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Открываем сундук...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Item item = new Item("Палка", 100);
            System.out.println("Получили предмет из сундука: " + item);
            return item;
        });
    }

    public CompletableFuture<Item> buyFromMarket() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Покупка в магазине...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Item item = new Item("Нож", 300);
            System.out.println("Получили предмет из магазина: " + item);
            return item;
        });
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.getFromChest()
                .thenCombine(inventory.buyFromMarket(), inventory::combine)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItems(item))).join();
        System.out.println("Все предметы в инвентаре: " + inventory.items);
    }
}
