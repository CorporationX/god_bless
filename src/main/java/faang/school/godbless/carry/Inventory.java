package faang.school.godbless.carry;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Data
public class Inventory {
    private final List<Item> items;
    private final List<Item> itemsInBox;
    private final List<Item> itemsInShop;
    private final Random random = new Random();

    public Inventory() {
        items = new ArrayList<>();
        itemsInBox = new ArrayList<>();
        itemsInShop = new ArrayList<>();
    }

    public void addItem(Item item) {
            System.out.println("Комбинированный предмет добавлен в инвентарь в потоке: " + Thread.currentThread().getName());
            items.add(item);
    }

    public Item combineItems(Item item, Item item2) {
        System.out.println("Комбинированный предмет получен в потоке: " + Thread.currentThread().getName());
        return new Item(item.getName() + "-" + item2.getName(), item.getPower() + item2.getPower());
    }

    public CompletableFuture<Item> getItemFromBox() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Получение предмета из коробки в потоке: " + Thread.currentThread().getName());
            return itemsInBox.get(random.nextInt(itemsInBox.size()));
        });
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Получение предмета из магазина в потоке: " + Thread.currentThread().getName());
            return itemsInShop.get(random.nextInt(itemsInShop.size()));
        });
    }
}
