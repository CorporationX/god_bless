package school.faang.task57454.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character pers, Item item, Consumer<Item> consumer) {
        pers.getInventory().add(item);
        consumer.accept(item);
    }

    public List<Item> removeItem(Character pers, Predicate<Item> condition) {
        List<Item> removeItems = new ArrayList<>();
        List<Item> inventory = pers.getInventory();

        inventory.removeIf(item -> {
            if (condition.test(item)) {
                return true;
            }
            return false;
        });
        return removeItems;
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (predicate.test(item)) {
                inventory.set(i, updater.apply(item));  // Обновляем предмет в списке
            }
        }
    }
}
