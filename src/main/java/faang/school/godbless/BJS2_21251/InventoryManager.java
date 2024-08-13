package faang.school.godbless.BJS2_21251;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character.getInventory() != null) {
            character.getInventory().add(item);
            consumer.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        if (character.getInventory() != null) {
            character.getInventory().removeIf(condition);
        }
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> function) {
        if (character.getInventory() != null) {
            for (int i = 0; i < character.getInventory().size(); i++) {
                Item item = character.getInventory().get(i);
                if (condition.test(item)) {
                    Item newItem = function.apply(item);
                    character.getInventory().remove(i);
                    character.getInventory().add(i, newItem);
                }
            }
        }
    }
}
