package faang.school.godbless.lotr;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemHandler) {
        character.getInventory().add(item);
        itemHandler.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemCondition) {
        if (character.getInventory() != null) {
            character.getInventory().removeIf(itemCondition);
        }
    }

    public void updateItem(Character character, Predicate<Item> itemCondition, Function<Item, Item> updateFunction) {
        if (character.getInventory() != null) {
            for (Item item : character.getInventory()) {
                if (itemCondition.test(item)) {
                    character.getInventory().set(character.getInventory().indexOf(item), updateFunction.apply(item));
                }
            }
        }
    }
}
