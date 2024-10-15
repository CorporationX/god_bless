package school.faang.bjs2_33879.service;

import school.faang.bjs2_33879.constants.ErrMessageValidate;
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
            throw new IllegalStateException(ErrMessageValidate.ITEMS_IS_NULL);
        }
    }

    public void validateAddItem(Character character, Item item, Consumer<Item> additionalAction) {
        validateNotNull(character, ErrMessageValidate.CHARACTER_IS_NULL);
        validateNotNull(item, ErrMessageValidate.ITEM_IS_NULL);
        validateNotNull(additionalAction, ErrMessageValidate.ADDITIONAL_ACTION_IS_NULL);
    }

    public void validateRemoveItem(Character character, Item item, Predicate<Item> deletionCondition) {
        validateNotNull(character, ErrMessageValidate.CHARACTER_IS_NULL);
        validateNotNull(item, ErrMessageValidate.ITEM_IS_NULL);
        validateNotNull(deletionCondition, ErrMessageValidate.CONDITION_IS_NULL);
        validateInventoryNotNull(character);
    }

    public void validateUpdateItem(Character character, Predicate<Item> updCondition, Function<Item, Item> updateAction) {
        validateNotNull(character, ErrMessageValidate.CHARACTER_IS_NULL);
        validateNotNull(updCondition, ErrMessageValidate.CONDITION_IS_NULL);
        validateNotNull(updateAction, ErrMessageValidate.UPDATE_ACTION_IS_NULL);
        validateInventoryNotNull(character);
    }
}
