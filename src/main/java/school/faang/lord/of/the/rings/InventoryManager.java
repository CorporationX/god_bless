package school.faang.lord.of.the.rings;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemHandler) {
        validateCharacter(character);
        if (item == null) {
            throw new IllegalArgumentException("item не может быть null");
        }
        if (itemHandler == null) {
            throw new IllegalArgumentException("itemHandler не может быть null");
        }

        character.addItem(item);
        itemHandler.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> removeCondition) {
        if (character == null) {
            return;
        }
        validatePredicate(removeCondition, "removeCondition не может быть null");

        Optional<Item> itemOptional = character.getInventory().stream()
                .filter(removeCondition)
                .findFirst();
        itemOptional.ifPresent(character::removeItem);
    }

    public void updateItem(Character character, Predicate<Item> updateCondition, Function<Item, Item> itemModifier) {
        validateCharacter(character);
        validatePredicate(updateCondition, "updateCondition не может быть null");
        if (itemModifier == null) {
            throw new IllegalArgumentException("itemModifier не может быть null");
        }

        character.updateItem(updateCondition, itemModifier);
    }

    private static void validateCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("character не может быть null");
        }
    }

    private static void validatePredicate(Predicate<Item> updateCondition, String message) {
        if (updateCondition == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
