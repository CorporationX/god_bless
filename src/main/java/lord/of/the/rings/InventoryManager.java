package lord.of.the.rings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        character.getInventory()
            .stream()
            .filter(itemPredicate)
            .toList()
            .stream()
            .forEach(item -> character.getInventory().remove(item));
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
        character.getInventory()
            .stream()
            .filter(itemPredicate)
            .forEach(item -> {
                int index = character.getInventory().indexOf(item);
                character.getInventory().set(index, itemFunction.apply(item));
            });
    }

    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }
}
