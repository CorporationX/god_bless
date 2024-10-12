package lordOfTheRingsRpg;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.addItem(item);
    }

    public void removeItem(Character character,Predicate<Item> filter) {
        List<Item> itemsForRemove = new ArrayList<>();

        character.getInventory().forEach(item -> {
            if(filter.test(item)) {
                itemsForRemove.add(item);
            }
        });

        character.getInventory().removeAll(itemsForRemove);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> action) {
        character.getInventory().forEach(item -> {
           if (filter.test(item)) {
               action.apply(item);
           }
        });
    }
}
