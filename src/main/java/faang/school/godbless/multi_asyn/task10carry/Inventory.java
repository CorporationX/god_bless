package faang.school.godbless.multi_asyn.task10carry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        items.add(item);
        System.out.println("Предмет добавлен");
    }

    public Item combineItems(Item item1, Item item2) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String name = item1.getName() + "_" + item2.getName();
        int power = item1.getPower() + item2.getPower();
        System.out.println("Предметы слиты");
        return new Item(name, power);
    }

    public CompletableFuture<Item> getFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Предмет получен из сундука");

            return new Item("Sword", 7);
        });
    }

    public CompletableFuture<Item> getFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Предмет куплен");
            return new Item("Gun", 100);
        });
    }
}
