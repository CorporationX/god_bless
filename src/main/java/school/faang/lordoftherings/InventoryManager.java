package school.faang.lordoftherings;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        validateCharacter(character);
        Objects.requireNonNull(item, "Item is null");
        Objects.requireNonNull(consumer, "Consumer is null");
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
        Objects.requireNonNull(function, "Function is null");
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
}
