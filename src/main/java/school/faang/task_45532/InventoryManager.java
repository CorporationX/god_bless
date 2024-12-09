package school.faang.task_45532;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> action) {
        List<Item> actionInventory = character.getInventory().stream()
                .map(item -> {
                    if (predicate.test(item)) {
                        return action.apply(item);
                    }
                    return item;
                })
                .toList();
        character.setInventory(actionInventory);
    }
}

