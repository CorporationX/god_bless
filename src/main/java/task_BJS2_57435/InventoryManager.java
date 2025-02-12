package task_BJS2_57435;

import lombok.NonNull;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(@NonNull Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(@NonNull Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(@NonNull Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                item.setValue(function.apply(item).getValue());
                item.setName(function.apply(item).getName());
            }
        }
    }
}
