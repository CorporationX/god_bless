package CarryOverFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public CompletableFuture<Item> addItemToInventoryAsync(Item item) {
        items.add(item);
        return CompletableFuture.completedFuture(item);
    }

    public CompletableFuture<Item> combineItemsAsync() {
        CompletableFuture<Item> item1Future = CompletableFuture.supplyAsync(this::getItem1FromBox);
        CompletableFuture<Item> item2Future = CompletableFuture.supplyAsync(this::getItem2FromGrocery);
        return item1Future.thenCombine(item2Future, (item1, item2) -> {
            double totalPower = item1.getPower() + item2.getPower();
            String newName = item1.getName() + " + " + item2.getName();
            return new Item(newName, totalPower);
        }).thenCompose(this::addItemToInventoryAsync);
    }

    private Item getItem1FromBox() {
        return new Item("Sword", 3);
    }

    private Item getItem2FromGrocery() {
        return new Item("Knife", 4);
    }


    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.combineItemsAsync()
                .thenCompose(inventory::addItemToInventoryAsync)
                .thenAccept(item -> System.out.println("Предмет " + item.getName() + " добавлен в инвентарь!!"));
    }
}

