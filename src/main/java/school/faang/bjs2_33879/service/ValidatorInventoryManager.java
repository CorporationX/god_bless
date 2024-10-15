package school.faang.bjs2_33879.service;

import school.faang.bjs2_33879.model.Character;
import school.faang.bjs2_33879.model.Item;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ValidatorInventoryManager {
    private void validateNotNull(Object object, String errMessage) {
        if (object == null) {
            throw new IllegalArgumentException(errMessage);
        }
    }

    private void validateInventoryNotNull(Character character) {
        List<Item> inventory = character.getInventory();
        if (inventory == null) {
            throw new IllegalStateException("list items cannot be null");
        }
    }

    public void validateAddItem(Character character, Item item, Consumer<Item> additionalAction) {
        validateNotNull(character, "character cannot be null");
        validateNotNull(item, "item cannot be null");
        validateNotNull(additionalAction,  "additional action cannot be null");
    }

    public void validateRemoveItem(Character character, Item item, Predicate<Item> deletionCondition) {
        validateNotNull(character, "character cannot be null");
        validateNotNull(item, "item cannot be null");
        validateNotNull(deletionCondition, "condition cannot be null");
        validateInventoryNotNull(character);
    }

    public void validateUpdateItem(Character character, Predicate<Item> updCondition, Function<Item, Item> updateAction) {
        validateNotNull(character, "character cannot be null");
        validateNotNull(updCondition, "condition cannot be null");
        validateNotNull(updateAction, "update action cannot be null");
        validateInventoryNotNull(character);
    }
}
