package sprint5.dota;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Data
public class Inventory {
    private static final List<Item> ALL_ITEMS = List.of(
            new Item("Quelling Blade", 8), new Item("Falcon Blade", 14), new Item("Crystalys", 32),
            new Item("Blades of Attack", 9), new Item("Broadsword", 15), new Item("Butterfly", 25)
    );
    private static final Random RANDOM = new Random();

    private final List<Item> items = new ArrayList<>();

    public CompletableFuture<Item> getItemFromChest(String characterName) {
        return CompletableFuture.supplyAsync(() -> {
            delayInReceivingItem();
            Item item = ALL_ITEMS.get(RANDOM.nextInt(ALL_ITEMS.size()));
            System.out.printf("%s received from the chest %s\n", characterName, item.name());
            return addItem(item);
        });
    }

    public CompletableFuture<Item> getItemFromShop(String characterName) {
        return CompletableFuture.supplyAsync(() -> {
            delayInReceivingItem();
            Item item = ALL_ITEMS.get(RANDOM.nextInt(ALL_ITEMS.size()));
            System.out.printf("%s bought at %s shop\n", characterName, item.name());
            return addItem(item);
        });
    }

    public CompletableFuture<Item> combineItem(CompletableFuture<Item> firstItem, CompletableFuture<Item> secondItem) {
        return firstItem.thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                return secondItem.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }), (item1, item2) -> {
            String combineName = item1.name() + " - " + item2.name();
            Item combineItem = new Item(combineName, item1.power() + item2.power());
            removeItem(item1);
            removeItem(item2);
            return combineItem;
        }).thenCompose(newItem -> CompletableFuture.supplyAsync(() -> addItem(newItem)));
    }

    private Item addItem(Item item) {
        items.add(item);
        return item;
    }

    private void removeItem(Item item) {
        items.remove(item);
    }

    private void delayInReceivingItem() {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
