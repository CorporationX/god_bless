package faang.school.godbless.LordOfTheRingsRPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character.getInventory().add(item))
            consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
            character.getInventory().remove(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        if(predicate.test())
        character.getInventory().
    }
}
