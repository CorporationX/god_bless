package faang.school.godbless.LordOfTheRingsRPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    void addItem(Character character, Item item, Consumer<Item> action) {
        character.inventory().add(item);
        action.accept(item);
    }

    void removeItem(Character character, Predicate<Item> condition) {
        character.inventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updater) {
        for (Item item : character.inventory()) {
            if (filter.test(item)) {
                character.inventory().set(character.inventory().indexOf(item), updater.apply(item));
                break;
            }
        }
    }
}

