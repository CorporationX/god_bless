package school.faang.task_bjs245611;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class InventoryManager {
    @NonNull
    Character character;

    public void addItem(Item item, @NonNull Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> items = character.getInventory();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (predicate.test(item)) {
                items.set(i, function.apply(item));
            }
        }
    }
}
