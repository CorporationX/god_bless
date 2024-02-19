package faang.school.godbless.r_edzie.lambdas.lotr;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> update) {
        var inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            if (condition.test(inventory.get(i))) {
                inventory.set(i, update.apply(inventory.get(i)));
            }
        }
    }
}
