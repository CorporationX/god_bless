package faang.school.godbless.BJS2_5030;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> onSuccess) {
        character.getInventory().add(item);
        onSuccess.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updateFunction) {
        List<Item> items = character.getInventory();
        int sizeListInventory = items.size();
        for (int i = 0; i < sizeListInventory; i++) {
            if (condition.test(items.get(i))) {
                items.set(i, updateFunction.apply(items.get(i)));
            }
        }
    }
}