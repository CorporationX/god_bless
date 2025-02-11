package school.faang.lordoftherings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        character.getInventory().stream()
                .filter(predicate)
                .forEach(item -> {
                    Item newItem = function.apply(item);
                    item.setName(newItem.getName());
                    item.setValue(newItem.getValue());
                });
    }
}
