package school.faang.BJS2_33725;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void addItem(Character character, Item item, BiConsumer<Item, Character> action) {
        character.getInventory().add(item);
        action.accept(item, character);
    }

    public void removeItem(Character character, Predicate<Item> removeIfCondition) {
        character.getInventory().removeIf(removeIfCondition);
    }

    public void updateItem(Character character, Predicate<Item> finder, Function<Item, Item> modifier) {
        character.getInventory().forEach(item -> {
            if (finder.test(item)) {
                Item updated = modifier.apply(item);
                item.setName(updated.getName());
                item.setValue(updated.getValue());
            }
        });
    }
}
