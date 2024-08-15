package faang.school.godbless.RPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Item item, Predicate<Item> predicate) {
        if (predicate.test(item)) {
            character.getInventory().remove(item);
            System.out.println(item.getName() + " was thrown away");
        } else {
            throw new IllegalArgumentException("Can not throw this item");
        }
    }

    public void updateItem(Character character, Item item, Predicate<Item> predicate, Function<Item, Item> function) {
        if (predicate.test(item)) {
            character.getInventory().add(function.apply(item));
            character.getInventory().remove(item);
        }
    }
}
