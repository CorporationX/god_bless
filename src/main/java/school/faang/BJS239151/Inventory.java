package school.faang.BJS239151;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Inventory {
    private List<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public CompletableFuture<Item> combineItems(Item item1, Item item2) {
        return CompletableFuture.supplyAsync(() -> {
            Item combinedItem = new Item(item1.getName() + "-" + item2.getName(), item1.getPower() + item2.getPower());
            System.out.println("Скомбинированный предмет: " + combinedItem.getName());
            return combinedItem;
        });
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Что-то пошло не так {}", e.getMessage());
            }
            return new Item("Chest Item", 10);
        });
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Что-то пошло не так {}", e.getMessage());
            }
            return new Item("Shop Item", 20);
        });
    }

    public CompletableFuture<Void> addItemToInventoryAsync(Item item) {
        return CompletableFuture.runAsync(() -> {
            this.addItem(item);
            System.out.println("Предмет добавлен в инвентарь: " + item.getName());
        });
    }
}
