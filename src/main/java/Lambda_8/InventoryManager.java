package Lambda_8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                character.getInventory().remove(item);
                break;
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                character.getInventory().remove(item);
                character.getInventory().add(function.apply(item));
                break;
            }
        }
    }


}
