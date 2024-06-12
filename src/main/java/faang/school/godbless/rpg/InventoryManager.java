package faang.school.godbless.rpg;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.inventory().add(item);
        consumer.accept(item);
    }

    public boolean removeItem(Character character, Predicate<Item> predicate) {
        return character.inventory().removeIf(predicate);
    }

    public Optional<Item> updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        return character.inventory().stream()
                .filter(predicate)
                .map(function)
                .findAny();
    }
}
