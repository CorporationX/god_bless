package school.faang.rpg;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> printAdd) {
        character.getInventory().add(item);
        printAdd.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> removeItem) {
        character.getInventory().removeIf(removeItem);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> apdateFunction) {
        List<Item> itemList = character.getInventory();

        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            if (predicate.test(item)) {
                itemList.set(i, apdateFunction.apply(item));
            }
        }
    }
}
