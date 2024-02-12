package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemAdd){
        character.addItemToInventory(item);
        itemAdd.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate){
        character.getInventory().removeIf(predicate);
        System.out.println(character.getInventory() + " deleted");
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function){
        List<Item> inventory = character.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            Item currentItem = inventory.get(i);
            if (predicate.test(currentItem)) {
                Item updatedItem = function.apply(currentItem);
                inventory.set(i, updatedItem);
                System.out.println("Item updated: " + updatedItem);
            }
        }
    }
}
