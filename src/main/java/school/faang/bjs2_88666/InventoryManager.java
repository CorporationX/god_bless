package school.faang.bjs2_88666;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character targetCharacter, Item itemToAdd, Consumer<Item> onItemAdded) {
        targetCharacter.getInventory().add(itemToAdd);
        onItemAdded.accept(itemToAdd);
    }

    public void removeItem(Character targetCharacter, Predicate<Item> removalCondition) {
        targetCharacter.getInventory().removeIf(removalCondition);
    }

    public void updateItem(Character targetCharacter,
                           Predicate<Item> updateCondition, Function<Item, Item> itemTransformer) {
        List<Item> inventory = targetCharacter.getInventory();
        for (int itemIndex = 0; itemIndex < inventory.size(); itemIndex++) {
            Item currentItem = inventory.get(itemIndex);
            if (updateCondition.test(currentItem)) {
                inventory.set(itemIndex, itemTransformer.apply(currentItem));
            }
        }
    }
}
