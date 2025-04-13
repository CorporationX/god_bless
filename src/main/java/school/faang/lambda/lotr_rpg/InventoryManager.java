package school.faang.lambda.lotr_rpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> onAddMsg) {
        character.inventory().add(item);
        onAddMsg.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.inventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        character.inventory().forEach(item -> {
            if (condition.test(item)) {
                character.inventory().set(character.inventory().indexOf(item), updater.apply(item));
            }
        });
    }
}
