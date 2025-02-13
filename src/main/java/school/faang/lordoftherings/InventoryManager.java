package school.faang.lordoftherings;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        validateCharacter(character);
        validateItem(item);
        validateConsumer(consumer);
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        validateCharacter(character);
        validatePredicate(predicate);
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        validateCharacter(character);
        validatePredicate(predicate);
        validateFunction(function);
        character.getInventory().replaceAll(item ->
                predicate.test(item) ? function.apply(item) : item
        );
    }

    private void validateCharacter(Character character) {
        Objects.requireNonNull(character, "Character is null");
    }

    private void validatePredicate(Predicate<Item> predicate) {
        Objects.requireNonNull(predicate, "Predicate is null");
    }

    private void validateFunction(Function<Item, Item> function) {
        Objects.requireNonNull(function, "Function is null");
    }

    private void validateConsumer(Consumer<Item> consumer) {
        Objects.requireNonNull(consumer, "Consumer is null");
    }

    private void validateItem(Item item) {
        Objects.requireNonNull(item, "Item is null");
    }
}
