package faang.school.godbless.lord.of.the.rings;

import java.io.IOError;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        for (int i = 0; i < character.getInventory().size(); i++) {
            if (predicate.test(character.getInventory().get(i))) {
                character.getInventory().remove(i);
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (int i = 0; i < character.getInventory().size(); i++) {
            if (predicate.test(character.getInventory().get(i))) {
                function.apply(character.getInventory().get(i));
            }
        }
    }
}
