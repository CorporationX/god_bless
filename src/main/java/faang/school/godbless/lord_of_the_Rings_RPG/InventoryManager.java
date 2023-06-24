package faang.school.godbless.lord_of_the_Rings_RPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {


    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character.getInventory().isEmpty()) {
            throw new IllegalStateException("empty list");
        }

        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        if (character.getInventory().isEmpty()) {
            throw new IllegalStateException("empty list");
        }

        for (int i = 0; i < character.getInventory().size(); i++) {
            if (predicate.test(character.getInventory().get(i))) {
                character.getInventory().set(i, function.apply(character.getInventory().get(i)));
            }
        }
    }
}
