package faang.school.godbless.lord_of_the_rings_rpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character == null) {
            throw new IllegalArgumentException("Аргумент character не может быть null.");
        }
        if (item == null) {
            throw new IllegalArgumentException("Аргумент item не может быть null.");
        }
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character == null) {
            throw new IllegalArgumentException("Аргумент character не может быть null.");
        }
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                character.getInventory().remove(item);
                return;
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        if (character == null) {
            throw new IllegalArgumentException("Аргумент character не может быть null.");
        }
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                character.getInventory().set(character.getInventory().indexOf(item), function.apply(item));
            }
        }
    }
}
