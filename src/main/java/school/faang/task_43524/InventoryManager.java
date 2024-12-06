package school.faang.task_43524;

import school.faang.task_43524.model.Character;
import school.faang.task_43524.model.Item;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Item item, Character character, Consumer<Item> action) {
        character.getItems().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getItems().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> action) {
        Item item = character.getItems().stream()
                .filter(predicate)
                .findFirst()
                .orElseThrow();

        item = action.apply(item);
    }
}
