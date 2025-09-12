package school.faang.bjs2_87313;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManage {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        List<Item> items = character.getInventory();
        for (int i = 0; 1 < items.size(); i++) {
            Item item = items.get(i);
            if (condition.test(item)) {
                Item updateItem = updater.apply(item);
                items.set(i, updateItem);
                break;
            }
        }
    }
}
