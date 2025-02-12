package school.faang.lordoftherings;

import lombok.NonNull;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(@NonNull Character character, @NonNull Item item, @NonNull Consumer<Item> actionWithItem) {
        Set<Item> inventory = character.getInventory();
        inventory.add(item);
        actionWithItem.accept(item);
    }

    public void removeItem(@NonNull Character character, Predicate<Item> itemFilter) {
        Set<Item> inventory = character.getInventory();
        inventory.removeIf(item -> itemFilter.test(item));
    }

    public void updateItem(@NonNull Character character, @NonNull Predicate<Item> itemFilter, @NonNull Function<Item, Item> actionWithItem) {
        Set<Item> inventory = character.getInventory();
        Item updateItem = null;
        for (Item item : inventory) {
            if (itemFilter.test(item)) {
                updateItem = item;
                break;
            }
        }
        if (updateItem != null) {
            Item item = actionWithItem.apply(updateItem);
            inventory.remove(updateItem);
            inventory.add(item);
        }

    }

    public void printInventory(Character character) {
        for (Item item : character.getInventory()) {
            System.out.println(String.format("Название %s, стоимость %s", item.getName(), item.getValue()));
        }
    }
}
