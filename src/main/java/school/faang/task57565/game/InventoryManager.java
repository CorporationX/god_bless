package school.faang.task57565.game;

import lombok.NonNull;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(@NonNull Character character, @NonNull Item item, @NonNull Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(@NonNull Character character, @NonNull Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(@NonNull Character character, @NonNull Predicate<Item> predicate,
                           @NonNull Function<Item, Item> function) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                item.setValue(function.apply(item).getValue());
            }
        }
    }
}
