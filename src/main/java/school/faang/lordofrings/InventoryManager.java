package school.faang.lordofrings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.inventory().add(item);
        consumer.accept(item);
    }

    public boolean removeItem(Character character, Predicate<Item> predicate) {
        return character.inventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> changeValue) {
        character.inventory().stream().filter(predicate).forEach(item -> {
            int index = character.inventory().indexOf(item);
            character.inventory().set(index, changeValue.apply(item));
        });
    }
}
