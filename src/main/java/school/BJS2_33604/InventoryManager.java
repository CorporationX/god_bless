package school.BJS2_33604;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getItems().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        character.getItems().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> action) {
        Iterator<Item> iterator = character.getItems().iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (filter.test(item)) {
                Item i = action.apply(item);
                removeItem(character, filter);
                character.getItems().add(i);
            }
        }
    }



}
