package faang.school.godbless.carryisoverfed3194;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Getter
@AllArgsConstructor
public class Inventory {
    private List<Item> items;

    public synchronized CompletableFuture<Item> addItem(Item item, ExecutorService executor) {
        if (this.getItems() == null) {
            this.items = new ArrayList<>();
        }
        return CompletableFuture.supplyAsync(() -> {
            this.getItems().add(item);
            return item;
        }, executor);
    }

    public synchronized CompletableFuture<Item> combineItems(Item item1, Item item2, ExecutorService executor) {
        if (!this.getItems().contains(item1) || !this.getItems().contains(item2)) {
            throw new NoSuchElementException("You can't combine items you ain't got");
        }
        return CompletableFuture.supplyAsync(() -> {
            Item combined = new Item(
                    String.format("%s_combinedWith_%s", item1.getName(), item2.getName()),
                    item1.getPower() + item2.getPower());
            this.getItems().remove(item1);
            this.getItems().remove(item2);
            return combined;
        }, executor);
    }
}
