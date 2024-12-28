package school.faang.bjs250832;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class Inventory {

    private List<Item> items = new ArrayList<>();
    private Random random = new Random();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        String name = item1.getName() + " " + item2.getName();
        int power = item1.getPower() + item2.getPower();
        return new Item(name, power);
    }

    public CompletableFuture<Item> getFromChest() {
        return createFutureItem();
    }

    public CompletableFuture<Item> getFromShop() {
        return createFutureItem();
    }

    private CompletableFuture<Item> createFutureItem() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5_000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new Item(UUID.randomUUID().toString(), random.nextInt(100));
        });
    }

}
