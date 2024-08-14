package faang.school.godbless.lordOfRings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        try {
            character.addItem(item);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> items = character.getInventory();
        for (int i = 0; i < items.size(); i++) {
            if (predicate.test(items.get(i))) {
                Item item = function.apply(items.get(i));
                items.set(i, item);
            }
        }
    }

}
