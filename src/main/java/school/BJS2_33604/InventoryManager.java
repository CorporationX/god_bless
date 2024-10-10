package school.BJS2_33604;

import java.util.List;
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
        List<Item> items = character.getItems();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (filter.test(item)) {
                items.set(i, action.apply(item));
                break;
            }
        }
    }


}
