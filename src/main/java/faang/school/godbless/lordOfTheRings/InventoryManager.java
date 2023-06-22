package faang.school.godbless.lordOfTheRings;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> callback) {
        character.getInventory().add(item);
        callback.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        Optional<Item> itemForRemove = character.getInventory().stream().filter(condition).findFirst();
        itemForRemove.ifPresent(item -> character.getInventory().remove(item));
    }

    public void removeAllItemsThatMatchCondition(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updateItem) {
        Item currentItem;
        for (int i =0; i < character.getInventory().size(); i++) {
            currentItem = character.getInventory().get(i);
            if (condition.test(currentItem)){
                character.getInventory().set(i, updateItem.apply(currentItem));
            }
        }
    }
}
