package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item,
                        Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> removingItems = character.getInventory()
                                            .stream()
                                            .filter(predicate)
                                            .toList();

        for (Item item : removingItems) {
            character.getInventory().remove(item);
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate,
                                              Function<Item, Item> function) {

        List<Item> itemsForUpdating = character.getInventory()
                                               .stream()
                                               .filter(predicate)
                                               .toList();

        List<Item> newInventory = new ArrayList<Item>(character.getInventory());

        for (Item itemForUpdating : itemsForUpdating) {
            for (Item item : character.getInventory()) {

                if (itemForUpdating.equals(item)) {
                    newInventory.remove(item);
                    newInventory.add(function.apply(itemForUpdating));
                }
            }
        }

        character.setInventory(newInventory);
    }

}
