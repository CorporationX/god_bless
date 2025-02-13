package school.faang.bjs2_57397;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> callback) {
        validate(character, "character");
        validate(item, "item");
        validate(callback, "callback");
        ensureItemListInitialized(character);

        character.getItems().add(item);
        callback.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        validate(character, "character");
        validate(filter, "filter");
        ensureItemListInitialized(character);

        character.getItems().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Consumer<Item> update) {
        validate(character, "character");
        validate(filter, "filter");
        validate(update, "update");
        ensureItemListInitialized(character);

        character.getItems().stream()
                .filter(filter)
                .forEach(update);
    }

    private void ensureItemListInitialized(Character character) {
        if (character.getItems() == null) {
            throw new IllegalStateException("Character's item list is not initialized");
        }
    }

    private <T> void validate(T obj, String name) {
        Objects.requireNonNull(obj, name + " is null");
    }
}
