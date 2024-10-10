package dima.evseenko.rpg;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> result) {
        if (Objects.nonNull(character) && Objects.nonNull(item) && Objects.nonNull(result)) {
            character.getItems().add(item);
            result.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        if (Objects.nonNull(character) && Objects.nonNull(condition)) {
            character.getItems().removeIf(condition);
        }
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updateFunction) {
        if (Objects.nonNull(character) && Objects.nonNull(condition) && Objects.nonNull(updateFunction)) {
            character.getItems().forEach((item -> {
                if (condition.test(item)) {
                    Item updated = updateFunction.apply(item);
                    item.setName(updated.getName());
                    item.setValue(updated.getValue());
                }
            }));
        }
    }
}
