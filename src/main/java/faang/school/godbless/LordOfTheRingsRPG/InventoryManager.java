package faang.school.godbless.LordOfTheRingsRPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    void addItem(Character character, Item item, Consumer<Item> action) {
        character.addItem(item);
        action.accept(item);
    }

    void removeItem(Character character, Predicate<Item> condition) {
        character.removeItem(condition);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updater) {
        character.updateItem(filter, updater);
    }
}

