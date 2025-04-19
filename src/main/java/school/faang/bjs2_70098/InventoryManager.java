package school.faang.bjs2_70098;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, UnaryOperator<Item> function) {
        character.getInventory().replaceAll(item -> {
            if (predicate.test(item)) {
                return function.apply(item);
            }
            return item;
        });
    }
}
