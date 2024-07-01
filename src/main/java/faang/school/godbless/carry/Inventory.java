package faang.school.godbless.carry;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item firstItem, Item secondItem) {
        if (items.contains(firstItem) && items.contains(secondItem)) {
            items.remove(firstItem);
            items.remove(secondItem);

            return new Item(firstItem.getName() + secondItem.getName(),
                    firstItem.getPower() * secondItem.getPower());
        } else {
            throw new IllegalArgumentException("There are no such items in the inventory");
        }
    }

    public CompletableFuture<Item> getFromChest(Chest chest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return chest.getDrop();
        });
    }

    public CompletableFuture<Item> getFromShop(Shop shop) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return shop.buyItem();
        });
    }

}
