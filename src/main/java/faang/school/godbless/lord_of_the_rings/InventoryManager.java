package faang.school.godbless.lord_of_the_rings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.addItem(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> itemsForRemove = character.getInventory().stream()
                .filter(predicate)
                .toList();

        itemsForRemove.forEach(character::removeItem);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        character.getInventory().stream()
                .filter(predicate)
                .map(function)
                .forEach(System.out::println);
    }
}