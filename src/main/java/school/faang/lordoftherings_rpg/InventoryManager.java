package school.faang.lordoftherings_rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        List<Item> inventory = character.getInventory();
        inventory.add(item);

        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> inventory = character.getInventory();
        List<Item> resultInventory = new ArrayList<>();
        for (Item item : inventory) {
            if (!predicate.test(item)) {
                resultInventory.add(item);
            }
        }
        character.setInventory(resultInventory);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        List<Item> resultInventory = new ArrayList<>();
        for (Item item : inventory) {
            if (predicate.test(item)) {
                item = function.apply(item);
            }
            resultInventory.add(item);
        }
        character.setInventory(resultInventory);
    }
}
