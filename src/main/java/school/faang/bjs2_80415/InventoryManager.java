package school.faang.bjs2_80415;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (Objects.isNull(item)) {
            System.out.println("Item isn't found");
            return;
        }
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> copyOfItems = List.copyOf(character.getInventory());
        copyOfItems.forEach(item -> {
            if (predicate.test(item)) {
                character.getInventory().remove(item);
            }
        });
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> copyOfItems = List.copyOf(character.getInventory());
        copyOfItems.forEach(item -> {
            if (predicate.test(item)) {
                character.getInventory().remove(item);
                character.getInventory().add(function.apply(item));
            }
        });
    }
}