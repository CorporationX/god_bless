package faang.school.godbless.ThirdSprint.BJS2_25151;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;

@Getter
public class Inventory {
    private List<Item> items = new CopyOnWriteArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item first, Item second) {
        return new Item(first.getName() + " : " + second.getName(),
                first.getPower() + second.getPower());
    }

    public CompletableFuture<Item> getFromBox(Supplier<Item> supplier) {
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.supplyAsync(supplier);
    }

    public CompletableFuture<Item> getFromShop(Supplier<Item> supplier) {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.supplyAsync(supplier);
    }

    public void inventoryAutoCombine(CompletableFuture<Item> first, CompletableFuture<Item> second) {
        first
                .thenCombine(second, (item1, item2) -> combineItems(item1, item2))
                .thenCompose(item -> CompletableFuture.runAsync(() -> addItem(item)));
    }
}
