package lord.of.the.rings.rpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> addFunction) {
        character.getInventory().add(item);
        addFunction.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updateFunction) {
        for (int i = 0; i < character.getInventory().size(); i++) {
            Item item = character.getInventory().get(i);
            if (predicate.test(item)) {
                character.getInventory().set(i, updateFunction.apply(item));
            }
        }
    }
}
