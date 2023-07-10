package faang.school.godbless.sprint_3.multithreading_future.carry_feeded;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Inventory {
    private final List<Item> items;
    private final List<Item> treasureItems = List.of(new Item("Belt of Strength", 5),
            new Item("Boots of Speed", 2),
            new Item("Gloves of Agility", 4),
            new Item("Cloak of Death", 8));
    private final List<Item> marketItems = List.of(new Item("Poisoned recipe", 4),
            new Item("Improved recipe", 2),
            new Item("Death recipe", 8),
            new Item("Bleeding recipe", 5));

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item itemBeConverted, Item itemThatCombines) {
        String partOfNewItem = itemThatCombines.getName().split(" ")[0];
        int newPower = itemBeConverted.getPower() + itemThatCombines.getPower();
        return new Item(partOfNewItem + " " + itemBeConverted.getName(), newPower);
    }

    public CompletableFuture<Item> getItemFromChest() {
        int random = ThreadLocalRandom.current().nextInt(treasureItems.size());
        return CompletableFuture.supplyAsync(() -> treasureItems.get(random));
    }

    public CompletableFuture<Item> getItemFromMarket(int id) {
        if (id < 0 || id > marketItems.size()) {
            throw new IllegalArgumentException("Item with that id doesn't exist in our market");
        }
        return CompletableFuture.supplyAsync(() -> marketItems.get(id));
    }
}