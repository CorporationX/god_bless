package faang.school.godbless.dota2;

import lombok.AllArgsConstructor;

import java.util.AbstractQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

@AllArgsConstructor
public class Inventory {
    AbstractQueue<Item> chest = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        AbstractQueue<Item> chest = new ConcurrentLinkedQueue<>();
        chest.add(new Item("shield", 5));
        chest.add(new Item("spear", 10));
        chest.add(new Item("bow", 8));

        Inventory inventory = new Inventory(chest);

        inventory.generateNewItemAndPutItToChest();

        inventory.chest.forEach(System.out::println);
    }

    public CompletableFuture<Void> generateNewItemAndPutItToChest() {
        return getFirstItemFromChest()
                .thenCombine(getFirstItemFromShop(), this::combineItems)
                .thenCompose(item -> addItemToChest(item.join()));
    }

    private CompletableFuture<Item> getFirstItemFromChest() {
        return CompletableFuture.supplyAsync(() -> chest.poll());
    }

    private CompletableFuture<Item> getFirstItemFromShop() {
        return CompletableFuture.supplyAsync(() -> new Item("sword", 12));
    }

    private CompletableFuture<Item> combineItems(Item item1, Item item2) {
        return CompletableFuture.supplyAsync(() -> {
            return new Item(
                    "%s_%s".formatted(item1.name(), item2.name()),
                    item1.power() + item2.power()
            );
        });
    }

    private CompletableFuture<Void> addItemToChest(Item item) {
        return CompletableFuture.runAsync(() -> chest.add(item));
    }
}
