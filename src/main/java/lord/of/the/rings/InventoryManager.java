package lord.of.the.rings;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        Optional<Item> item = character.getInventory()
            .stream()
            .filter(itemPredicate)
            .findFirst();

        if (item.isPresent()) {
            character.getInventory().remove(item.get());
        } else {
            throw new RuntimeException("Предмет не был найден");
        }
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
        character.getInventory().replaceAll(item -> itemPredicate.test(item) ? itemFunction.apply(item) : item);
    }

    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }
}
