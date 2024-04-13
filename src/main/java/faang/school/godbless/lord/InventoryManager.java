package faang.school.godbless.lord;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
         character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            if (predicate.test(inventory.get(i))) {
                inventory.set(i, function.apply(inventory.get(i)));
            }
        }
    }
}