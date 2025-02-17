package school.faang.sprint2.bjs2_57543;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(@NonNull Character person, @NonNull Item item, @NonNull Consumer<Item> action) {
        person.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(@NonNull Character person, @NonNull Predicate<Item> filter) {
        person.getInventory().removeIf(filter);
    }

    public void updateItem(@NonNull Character person, @NonNull Predicate<Item> filter,
                           @NonNull Function<Item, Item> updateItem) {
        List<Item> inventory = person.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (filter.test(item)) {
                inventory.set(i, updateItem.apply(item));
            }
        }
    }


}
