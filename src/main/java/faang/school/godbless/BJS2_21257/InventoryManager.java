package faang.school.godbless.BJS2_21257;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public static void addItem(Character character, Item item, Consumer<Item> action) {
        character.add(item);
        action.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> condition) {
        character.removeIf(condition);
    }

    public static void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updateAction) {
        Set<Item> updatedItems = new HashSet<>();
        character.getItems()
                .forEach(item -> {
                    if (condition.test(item)) {
                        updatedItems.add(updateAction.apply(item));
                    } else {
                        updatedItems.add(item);
                    }
                });
        character.setItems(updatedItems);
    }
}
