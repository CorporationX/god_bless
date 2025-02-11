package school.faang.bjs2_57397;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> callback) {
        validateCharacter(character);
        validateItem(item);
        validateConsumer(callback);

        character.getItems().add(item);
        callback.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        validateCharacter(character);
        validatePredicate(filter);

        character.getItems().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Consumer<Item> update) {
        validateCharacter(character);
        validatePredicate(filter);
        validateConsumer(update);

        if (character.getItems() != null) {
            character.getItems().stream().filter(filter).forEach(update);
        } else {
            throw new IllegalStateException("The character does not contain any item");
        }
    }

    private void validateCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Character is null");
        }
    }

    private void validateItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null");
        }
    }

    private void validateConsumer(Consumer<Item> callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Consumer is null");
        }
    }

    private void validatePredicate(Predicate<Item> callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Predicate is null");
        }
    }
}
