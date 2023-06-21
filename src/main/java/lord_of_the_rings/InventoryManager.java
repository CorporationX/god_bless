package lord_of_the_rings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> successConsumer) {
        character.inventory().add(item);
        successConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.inventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updateFunction) {
        character.inventory().stream()
                .filter(condition)
                .findFirst()
                .ifPresent(foundItem -> {
                    int index = character.inventory().indexOf(foundItem);
                    Item updatedItem = updateFunction.apply(foundItem);
                    character.inventory().set(index, updatedItem);
                });
    }
}
