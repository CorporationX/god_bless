package school.faang.task45502;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {

    private void validateCharacterAndItem(Character character, Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item is null");
        }
        validateCharacter(character);
    }

    private void validateCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("character is null");
        }
    }

    public void addItem(Character character, Item item, Consumer<Item> additionalAction) {
        validateCharacterAndItem(character, item);
        if (additionalAction == null) {
            throw new IllegalArgumentException("additionalAction is null");
        }

        character.getInventory().add(item);
        additionalAction.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> deletionCondition) {
        validateCharacter(character);
        if (deletionCondition == null) {
            throw new IllegalArgumentException("deletionCondition is null");
        }
        List<Item> inventory = character.getInventory();

        inventory.removeIf(deletionCondition);
    }

    public void updateItem(Character character,
                           Predicate<Item> itemPredicate,
                           Consumer<Item> itemUpdater) {
        validateCharacter(character);
        if (itemUpdater == null) {
            throw new IllegalArgumentException("itemUpdater is null");
        }
        if (itemPredicate == null) {
            throw new IllegalArgumentException("itemPredicate is null");
        }

        List<Item> inventory = character.getInventory();

        for (var item : inventory) {
            if (itemPredicate.test(item)) {
                itemUpdater.accept(item);
            }
        }
    }

}
