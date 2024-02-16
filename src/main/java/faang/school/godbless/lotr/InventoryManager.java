package faang.school.godbless.lotr;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemHandler) {
        if (character.getInventory() != null) {
            character.getInventory().add(item);
            itemHandler.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> itemCondition) {
        if (character.getInventory() != null) {
            character.getInventory().removeIf(itemCondition);
        }
    }

    public void updateItem(Character character, Predicate<Item> itemCondition, Function<Item, Item> updateFunction) {
        if (character.getInventory() != null) {
            List<Item> items = character.getInventory();
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                if (itemCondition.test(item)) {
                    character.getInventory().set(i, updateFunction.apply(item));
                }
            }
        }
    }
}
