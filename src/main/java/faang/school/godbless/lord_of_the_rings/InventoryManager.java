package faang.school.godbless.lord_of_the_rings;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> inventoryList = new ArrayList<>(character.getInventory());
        for (Item item : character.getInventory()) {
            if (predicate.test(item)){
                inventoryList.remove(item);
                System.out.println(item.getName() + " was removed from inventory");
            }
        }
        character.setInventory(inventoryList);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventoryList = new ArrayList<>(character.getInventory());
        for (Item item : character.getInventory()) {
            if (predicate.test(item)){
                inventoryList.remove(item);
                inventoryList.add(function.apply(item));
                System.out.println(item.getName() + " was modified");
            }
        }
        character.setInventory(inventoryList);
    }
}
