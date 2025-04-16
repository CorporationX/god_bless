package school.faang.bjs2_69996;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> printAddItem) {
        List<Item> itemsList = character.getInventory();
        if (itemsList != null) {
            itemsList.add(item);
            printAddItem.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> findItem) {
        List<Item> itemsList = character.getInventory();
        if (itemsList != null) {
            itemsList.removeIf(findItem);
        }
    }

    public void updateItem(Character character, Predicate<Item> findItem, Function<Item, Item> changeValue) {
        List<Item> itemsList = character.getInventory();
        if (itemsList != null) {
            for (int i = 0; i < itemsList.size(); i++) {
                Item item = itemsList.get(i);
                if (findItem.test(item)) {
                    itemsList.set(i, changeValue.apply(item));
                }
            }
        }
    }
}
