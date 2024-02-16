package faang.school.godbless;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemAdd){
        character.addItemToInventory(item);
        itemAdd.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition){
        List<Item> inventory = character.getInventory();
        Iterator<Item> iterator = inventory.iterator();

        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            if (condition.test(currentItem)) {
                iterator.remove();
                System.out.println(currentItem + " deleted");
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> functionForUpdate){
        List<Item> inventory = character.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            Item currentItem = inventory.get(i);
            if (condition.test(currentItem)) {
                Item updatedItem = functionForUpdate.apply(currentItem);
                inventory.set(i, updatedItem);
                System.out.println("Item updated: " + updatedItem);
            }
        }
    }
}
