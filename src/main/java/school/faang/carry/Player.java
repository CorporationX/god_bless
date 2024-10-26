package school.faang.carry;

import lombok.AccessLevel;
import lombok.Getter;
import school.faang.carry.storages.Chest;
import school.faang.carry.storages.Inventory;
import school.faang.carry.storages.Store;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Player {
    private final static Store STORE = new Store(List.of(
            new Item("Black King Bar", 120, 1200),
            new Item("Iron Branch", 1, 50),
            new Item("Morbid Mask", 20, 900),
            new Item("Blink Dagger", 45, 2250),
            new Item("Hyperstone", 65, 2000)
    ));

    private final String name;

    private final AtomicInteger cash;

    @Getter(AccessLevel.NONE)
    private final Inventory inventory = new Inventory();

    @Getter(AccessLevel.NONE)
    private final Chest chest;

    public Player(String name, int cash) {
        this.name = name;
        this.cash = new AtomicInteger(cash);
        chest = new Chest(name);
    }

    public int getCash() {
        return cash.get();
    }

    public CompletableFuture<Void> assembleItem(Item item1, Item item2) {
        CompletableFuture<Item> itemFromChestFuture = CompletableFuture.supplyAsync(
                () -> chest.getItem(item1, this));
        CompletableFuture<Item> itemFromStoreFuture = CompletableFuture.supplyAsync(
                () -> STORE.getItem(item2, this));
        CompletableFuture<Item> newItemFuture = itemFromChestFuture.thenCombine(
                itemFromStoreFuture, Inventory::combineItems);
        return newItemFuture.thenAccept(item -> {
            System.out.println("Предмет " + item.name() + " был скравчен");
            inventory.addItem(item);
        });
    }

    public void addItemsInChest(List<Item> items) {
        items.forEach(chest::addItem);
    }

    public void spendGold(int amount) {
        cash.addAndGet(-amount);
    }

    @Override
    public String toString() {
        return name;
    }
}
