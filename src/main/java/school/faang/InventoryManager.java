package school.faang;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        validateCharacter(character);
        validateItem(item);
        validateConsumer(action);
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        validateCharacter(character);
        validateCondition(condition);
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        validateCharacter(character);
        validateCondition(condition);
        validateFunction(updater);
        character.getInventory().replaceAll(item -> condition.test(item) ? updater.apply(item) : item);
    }

    private void validateCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Character can't be null.");
        }
    }

    private void validateItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item can't be null.");
        }
    }

    private <U> void validateConsumer(Consumer<U> consumer) {
        if (consumer == null) {
            throw new IllegalArgumentException("Consumer can't be null.");
        }
    }

    private <U> void validateCondition(Predicate<U> condition) {
        if (condition == null) {
            throw new IllegalArgumentException("Predicate can't be null.");
        }
    }

    private <U, V> void validateFunction(Function<U, V> function) {
        if (function == null) {
            throw new IllegalArgumentException("Function can't be null.");
        }
    }
}
