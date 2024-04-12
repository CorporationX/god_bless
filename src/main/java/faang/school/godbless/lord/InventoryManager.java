package faang.school.godbless.lord;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventories().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
         character.getInventories().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (Item item : character.getInventories()) {
            if (predicate.test(item)) {
                character.getInventories().set(character.getInventories().indexOf(item), function.apply(item));
            }
        }
    }
}