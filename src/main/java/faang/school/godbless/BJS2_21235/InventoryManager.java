package faang.school.godbless.BJS2_21235;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updateFunction) {
        for (int i = 0; i < character.getInventory().size(); i++) {
            if (predicate.test(character.getInventory().get(i))) {
                character.getInventory().set(i, updateFunction.apply(character.getInventory().get(i)));
            }
        }
    }
}
