package school.faang.sprint2.task45800.manager;

import school.faang.sprint2.task45800.model.Item;
import school.faang.sprint2.task45800.model.Character;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> doAction) {
        character.getInventory().add(item);
        doAction.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updater) {
        List<Item> items = character.getInventory();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (filter.test(item)) {
                items.set(i, updater.apply(item));
            }
        }
    }
}
