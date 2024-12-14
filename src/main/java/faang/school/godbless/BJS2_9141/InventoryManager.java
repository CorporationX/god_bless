package faang.school.godbless.BJS2_9141;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character.getInventory().contains(item)) {
            System.out.println("Item already exists");
            return;
        }
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character.getInventory().isEmpty()) {
            System.out.println("Inventory is empty");
            return;
        }
        if (character.getInventory().removeIf(predicate)) {
            System.out.println("Item has been removed");
        } else {
            System.out.println("Item not found");
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        var inventory = character.getInventory();
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty");
            return;
        }
        for (int i = 0; i < inventory.size(); i++) {
            if (predicate.test(inventory.get(i))) {
                Item item = function.apply(inventory.get(i));
                inventory.set(i, item);
                System.out.println("Item " + inventory.get(i).getName() + " has been updated");
            }
        }
    }
}
