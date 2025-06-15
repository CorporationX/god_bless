package school.faang.lord_of_the_rings_bjs2_80327;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings("checkstyle:CommentsIndentation")
@Slf4j
public class InventoryManager {
    public void addItem(@NonNull Character character, @NonNull Item item, Consumer<Item> consumer) {
        List<Item> inventory = character.getInventory();
        inventory.add(item);
        consumer.accept(item);
    }

    public void removeItem(@NonNull Character character, Predicate<Item> predicate) {
        List<Item> inventory = character.getInventory();
        inventory.removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        if (character == null) {
            log.warn("Персонаж не может быть null");
            return;
        }
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (predicate.test(item)) {
                Item updatedItem = function.apply(item);
                inventory.set(i, updatedItem);
            }
        }
    }
}
