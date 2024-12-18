package school.faang.bjs45643;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.inventory().add(item);
        if (action != null) {
            action.accept(item);
        }
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> action) {
        List<Item> updatedItems = character.inventory().stream()
                .map(item -> {
                    if (condition.test(item)) {
                        return action.apply(item);
                    } else {
                        return item;
                    }
                }).toList();

        character.inventory().clear();
        character.inventory().addAll(updatedItems);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character.inventory() != null && !character.inventory().isEmpty()) {
            character.inventory().removeIf(predicate);
        }
    }
}
