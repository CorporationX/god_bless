package faang.school.godbless.carry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Getter
public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        return new Item(item1.getName() + " " + item2.getName(), item1.getPower() + item2.getPower());
    }

    public CompletableFuture<Item> getItem() {
        return CompletableFuture.supplyAsync(() -> {
           try {
               Thread.sleep(1300);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           Item item = items.get(new Random().nextInt(items.size()));
           items.remove(item);
           return item;
        });
    }
}
