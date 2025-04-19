package school.faang.bjs2_71188;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.addItemToInventory(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updateItem) {
        character.getInventory()
            .stream()
            .filter(filter)
            .forEach(item -> item.setValue(updateItem.apply(item).getValue()));
    }
}
