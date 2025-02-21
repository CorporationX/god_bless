package school.faang.second_sprint.googlemaps.lotr;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, @NonNull Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> items = character.getInventory();

        for (Item itemInItems : items) {
            if (predicate.test(itemInItems)) {
                items.set(items.indexOf(itemInItems), function.apply(itemInItems));
            }
        }
    }
}


