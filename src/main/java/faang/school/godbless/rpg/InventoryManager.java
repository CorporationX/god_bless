package faang.school.godbless.rpg;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> handler) {
        List<Item> inventory = character.getInventory();

        inventory.add(item);
        handler.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        List<Item> inventory = character.getInventory();

        checkInventory(inventory);

        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (filter.test(item)) {
                inventory.remove(i);
                System.out.printf("%s was removed from inventory \n", item.getName());
                break;
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();

        checkInventory(inventory);

        for (Item item : inventory) {
            if (filter.test(item)) {
                inventory.remove(item);
                Item appliedItem = updater.apply(item);
                inventory.add(appliedItem);
            }
        }
    }

    private static void checkInventory(List<Item> inventory) {
        if (inventory.isEmpty()) {
            throw new IllegalArgumentException("Inventory is empty");
        }
    }
}
