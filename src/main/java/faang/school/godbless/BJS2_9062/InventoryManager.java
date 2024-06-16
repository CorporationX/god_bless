package faang.school.godbless.BJS2_9062;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        boolean resultOfAdding = false;
        if (character != null || item != null) {
            resultOfAdding = character.getInventory().add(item);
        }
        if (resultOfAdding) consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character != null || predicate != null) {
            character.getInventory().removeIf(predicate);
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> itemFunction) {
        if (character != null || predicate != null || itemFunction != null) {
            List<Item> inventory = character.getInventory();
            inventory.replaceAll(item -> predicate.test(item) ? itemFunction.apply(item) : item);
        }
    }

    public void showAllList(Character character) {
        if (character != null) {
            List<Item> inventory = character.getInventory();
            inventory.forEach((value) -> System.out.println(value));
        }
    }
}
