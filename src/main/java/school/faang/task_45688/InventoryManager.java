package school.faang.task_45688;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Item item, Character character, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Item item, Character character, Predicate<Item> predicate) {
        List<Item> inventoryItem = new ArrayList<>(character.getInventory());
        for (Item inventory : inventoryItem) {
            if (inventory.equals(item) && predicate.test(item)) {
                character.getInventory().remove(inventory);
                System.out.println("Вы удалили " + inventory);
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        int index = 0;
        for (Item item : inventory) {
            if (predicate.test(item)) {
                inventory.set(index, function.apply(item));
            }
            index++;
        }
    }
}