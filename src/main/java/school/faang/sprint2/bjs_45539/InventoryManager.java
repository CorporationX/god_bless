package school.faang.sprint2.bjs_45539;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character person, Item item, Consumer<Item> action) {
        if (person != null && item != null) {
            person.getInventory().add(item);
            action.accept(item);
        }
    }

    public void removeItem(Character person, Predicate<Item> condition) {
        person.getInventory().removeIf(condition);
    }

    public void updateItem(Character person, Predicate<Item> condition, Function<Item, Item> change) {
        person.getInventory().stream()
                .filter(condition)
                .forEach(item -> {
                    int newCost = change.apply(item).getItemCost();
                    item.setItemCost(newCost);
                });
    }
}
