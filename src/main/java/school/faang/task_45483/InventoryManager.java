package school.faang.task_45483;

import school.faang.task_45483.model.Character;
import school.faang.task_45483.model.Item;

import java.util.List;
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
        List<Item> items = character.getItems();

        Item item = items.stream()
                .filter(predicate)
                .findFirst()
                .orElseThrow();

        Item newItem = action.apply(item);

        items.remove(item);
        items.add(newItem);
    }
}
