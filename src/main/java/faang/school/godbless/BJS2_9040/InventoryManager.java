package faang.school.godbless.BJS2_9040;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> msg) {
        character.getInventory().add(item);
        msg.accept(item);
    }

    public void deleteItem(Character character, Predicate<Item> condition) {
        List<Item> inventory = character.getInventory().stream().filter(condition).toList();
        character.getInventory().removeAll(inventory);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updatedItem) {
        List<Item> items = character.getInventory().stream().filter(condition).toList();
        items.forEach(item -> {
            if (character.getInventory().contains(item)) {
                int id = character.getInventory().indexOf(item);
                item = updatedItem.apply(item);
                character.getInventory().set(id, item);
            }
        });
    }
}
