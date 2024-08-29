package faang.school.godbless.BJS2_24966;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class Inventory {
    private final List<Item> items;
    private final int INVENTORY_SIZE = 6;
    private final int ITEM_GETTING_TIME = 3;


    public void addItem(Item item) {
        if (items.size() == INVENTORY_SIZE) {
            System.out.println("Inventory is full");
        } else {
            items.add(item);
            System.out.println("Item" + item.name() + " was added");
        }
    }

    public Item combineItems(Item item1, Item item2) {

        String name = "Mix of " + item1.name() + "|" + item2.name();
        double strength = item1.strength() + item2.strength();
        double agility = item1.agility() + item2.agility();
        double intelligence = item1.intelligence() + item2.intelligence();

        return new Item(name, strength, agility, intelligence);
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(ITEM_GETTING_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return new Item("Circlet", 2.0, 2.0, 2.0);
        });
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(ITEM_GETTING_TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return new Item("Crown", 8.4, 4.2, 4.5);
        });
    }
}
