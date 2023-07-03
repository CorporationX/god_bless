package faang.school.godbless.sprint3.lambda.task14;

import java.util.List;
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

        List<Item> inventory = character.getInventory();
        inventory.removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        validateCharacter(character);
        validatePredicate(predicate);
        validateFunction(function);

        List<Item> inventory = character.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            if (predicate.test(inventory.get(i))) {
                Item item = function.apply(inventory.get(i));
                inventory.set(i, item);
            }
        }
    }

    public void validateCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Character не может быть null");
        }
    }

    public void validateItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item не может быть null");
        }
    }

    public void validateConsumer(Consumer<Item> consumer) {
        if (consumer == null) {
            throw new NullPointerException("Consumer не может быть null");
        }
    }

    public void validatePredicate(Predicate<Item> predicate) {
        if (predicate == null) {
            throw new NullPointerException("Predicate не может быть null");
        }
    }

    public void validateFunction(Function<Item, Item> function) {
        if (function == null) {
            throw new NullPointerException("Function не может быть null");
        }
    }
}
