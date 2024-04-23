package faang.school.godbless.FatCarry;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class Inventory {
    private final List<Item> items = new ArrayList<>();
    private final ExecutorService pool;

    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    public Item combineItems(Item first, Item second) {
        String newName = first.getName() + " -> " + second.getName();
        int combinedPower = first.getPower() + second.getPower();
        return new Item(newName, combinedPower);
    }

    public CompletableFuture<Item> getFromChest(List<Item> chest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return chest.get(ThreadLocalRandom.current().nextInt(0, chest.size()));

        }, pool);
    }

    public CompletableFuture<Item> buyFromShop(List<Item> itemsForSale) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return itemsForSale.get(ThreadLocalRandom.current().nextInt(0, itemsForSale.size()));
        }, pool);
    }
}
