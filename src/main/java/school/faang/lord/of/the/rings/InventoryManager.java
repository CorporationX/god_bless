package school.faang.lord.of.the.rings;

import java.util.List;
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

        List<Item> items = character.getInventory();
        items.add(item);
        character.setInventory(items);
        itemHandler.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> removeCondition) {
        if (character == null) {
            return;
        }
        validatePredicate(removeCondition, "removeCondition не может быть null");

        List<Item> items = character.getInventory();
        items.removeIf(removeCondition);
        character.setInventory(items);
    }

    public void updateItem(Character character, Predicate<Item> updateCondition, Function<Item, Item> itemModifier) {
        validateCharacter(character);
        validatePredicate(updateCondition, "updateCondition не может быть null");
        if (itemModifier == null) {
            throw new IllegalArgumentException("itemModifier не может быть null");
        }

        List<Item> items = character.getInventory();
        for (int i = 0; i < character.getInventory().size(); i++) {
            if (updateCondition.test(items.get(i))) {
                items.set(i, itemModifier.apply(items.get(i)));
            }
        }
        character.setInventory(items);
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
