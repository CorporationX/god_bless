package school.faang.naughtwoBJS257533;

import lombok.NoArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@NoArgsConstructor
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        checkCharacter(character);
        checkItem(item);
        checkConsumer(consumer);
        if (character.getInventory().contains(item)) {
            System.out.printf("%s is already in %s inventory.%n", item.getItemName(), character.getName());
        } else {
            character.getInventory().add(item);
            consumer.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        checkCharacter(character);
        checkCondition(condition);
        character.getInventory().removeIf(condition);
        System.out.println("Inventory cleared according to condition");
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> function) {
        checkCharacter(character);
        checkCondition(condition);
        checkFunction(function);
        for (Item item : character.getInventory()) {
            if (condition.test(item)) {
                Item newItem = function.apply(item);
                item.setValue(newItem.getValue());
                item.setItemName(newItem.getItemName());
            }
        }
    }

    private void checkCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Character cannot be 'null'.");
        }
    }

    private void checkItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be 'null'.");
        }
    }

    private void checkFunction(Function<Item, Item> function) {
        if (function == null) {
            throw new IllegalArgumentException("Function cannot be 'null'.");
        }
    }

    private void checkConsumer(Consumer<Item> consumer) {
        if (consumer == null) {
            throw new IllegalArgumentException("Consumer cannot be 'null'.");
        }
    }

    private void checkCondition(Predicate<Item> condition) {
        if (condition == null) {
            throw new IllegalArgumentException("Condition cannot be 'null'.");
        }
    }
}
