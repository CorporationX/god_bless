package faang.school.godbless.sprint2.lordOfTheRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public boolean removeItem(Character character, Predicate<Item> predicate) {
        return character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        character.setInventory(character.getInventory()
                .stream()
                .map(item -> predicate.test(item) ? function.apply(item) : item)
                .toList());
    }
}
