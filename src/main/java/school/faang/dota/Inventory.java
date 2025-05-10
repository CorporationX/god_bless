package school.faang.dota;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

public class Inventory {
    private final List<Item> items = new CopyOnWriteArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Предмет добавлен в инвентарь: " + item);
    }

    public CompletableFuture<Void> addItemAsync(Item item) {
        return CompletableFuture.runAsync(() -> addItem(item));
    }

    public Item combineItems(Item item1, Item item2) {
        String combinedName = item1.getName() + "+" + item2.getName();
        int combinedPower = item1.getPower() + item2.getPower();
        Item newItem = new Item(combinedName, combinedPower);
        System.out.println("Создан новый предмет: " + newItem);
        return newItem;
    }
}
