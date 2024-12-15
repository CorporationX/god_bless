package school.faang.sprint2.bjs_45630;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        if (character == null || item == null || action == null) {
            throw new IllegalArgumentException("Значение параметров не может быть равно null!");
        }

        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> verifAction) {
        if (character == null || verifAction == null) {
            throw new IllegalArgumentException("Значение параметров не может быть равно null!");
        }

        character.getInventory().removeIf(verifAction);
    }

    public void updateItem(Character character, Predicate<Item> action, Function<Item, Item> replaceAction) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (action.test(item)) {
                inventory.set(i, replaceAction.apply(item));
            }
        }
    }
}
