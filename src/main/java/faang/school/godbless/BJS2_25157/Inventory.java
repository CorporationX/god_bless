package faang.school.godbless.BJS2_25157;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Getter
public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public CompletableFuture<Item> combineItems(CompletableFuture<Item> item1, CompletableFuture<Item> item2) {
        return item1.thenCombine(item2, (res1, res2) -> new Item(res1.getName() + " " + res2.getName(), res1.getPower() + res2.getPower())).thenCompose(item -> CompletableFuture.supplyAsync(() -> {
            items.add(item);
            return item;
        }));
    }

    public CompletableFuture<Item> getFirstItem(String name) {
        return CompletableFuture.supplyAsync(() -> items.stream().filter(item -> item.getName().equalsIgnoreCase(name)).findFirst().orElseThrow(() -> new IllegalArgumentException("No item found")));
    }

    public CompletableFuture<Item> getSecondItem(String name) {
        return CompletableFuture.supplyAsync(() -> items.stream().filter(item -> item.getName().equalsIgnoreCase(name)).findFirst().orElseThrow(() -> new IllegalArgumentException("No item found")));
    }
}
