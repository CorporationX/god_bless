package faang.school.godbless.lords_of_rings;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character != null && item != null) {
            character.getInventory().add(item);
            consumer.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        if (character != null) {
            character.getInventory().removeIf(filter);
        }
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> function) {
        if (character.getInventory().isEmpty()) {
            throw new IllegalArgumentException("Characters inventory is empty!!!");
        }
        for (int i = 0; i < character.getInventory().size(); i++) {
            if (filter.test(character.getInventory().get(i))) {
                character.getInventory().replaceAll(item -> function.apply(item));
            } else {
                throw new NoSuchElementException("No such item");
            }
        }
    }
}
