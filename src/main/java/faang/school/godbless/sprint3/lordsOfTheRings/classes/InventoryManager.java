package faang.school.godbless.sprint3.lordsOfTheRings.classes;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> list = character.getInventory();
        for (Item item : list) {
            if (predicate.test(item)) {
                character.getInventory().remove(item);
                break;
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> list = character.getInventory();
        for (Item item : list) {
            if (predicate.test(item)) {
                removeItem(character, predicate);
                character.getInventory().add(function.apply(item));
                break;
            }
        }
    }
}
