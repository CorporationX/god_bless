package school.faang.bjs2_70001;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> secondaryAction) {
        character.addItem(item);
        secondaryAction.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.removeItem(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> update) {
        character.updateItem(filter, update);
    }
}
