package school.faang.task45502;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {

    private void validateCharacter(Character character, Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item is null");
        }
        validateItem(character);
    }

    private void validateItem(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("character is null");
        }
    }

    public void addItem(Character character, Item item, Consumer<Item> additionalAction) {
        validateCharacter(character, item);
        if (additionalAction == null) {
            throw new IllegalArgumentException("additionalAction is null");
        }

        character.getInventory().add(item);
        additionalAction.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> deletionCondition) {
        validateItem(character);
        if (deletionCondition == null) {
            throw new IllegalArgumentException("deletionCondition is null");
        }
        List<Item> inventory = character.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            if (deletionCondition.test(inventory.get(i))) {
                character.getInventory().remove(i);
                i--;
                System.out.println("Removed " + inventory.get(i + 1));
            }
        }
    }

    public void updateItem(Character character,
                           Predicate<Item> findCondition,
                           Consumer<Item> updateCondition) {
        validateItem(character);
        if (updateCondition == null) {
            throw new IllegalArgumentException("updateCondition is null");
        }

        List<Item> inventory = character.getInventory();

        for (var item : inventory) {
            if (findCondition.test(item)) {
                updateCondition.accept(item);
            }
        }
    }

}
