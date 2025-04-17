package school.faang.bjs2_69996;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> printAddItem) {
        List<Item> itemsList = getInventoryAndCheckNpe(character);
        itemsList.add(item);
        printAddItem.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> findItem) {
        List<Item> itemsList = getInventoryAndCheckNpe(character);
        itemsList.removeIf(findItem);
    }

    public void updateItem(Character character, Predicate<Item> findItem, Function<Item, Item> changeValue) {
        List<Item> itemsList = getInventoryAndCheckNpe(character);
        for (int i = 0; i < itemsList.size(); i++) {
            Item item = itemsList.get(i);
            if (findItem.test(item)) {
                itemsList.set(i, changeValue.apply(item));
            }
        }
    }

    private static List<Item> getInventoryAndCheckNpe(Character character) {
        List<Item> itemsList = character.getInventory();
        if (itemsList == null) {
            throw new NullPointerException("List of Items not found!!!");
        }
        return itemsList;
    }
}
