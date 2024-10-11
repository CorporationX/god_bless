package school.faang.BJS233632;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character frodo, Item ring, Consumer<Item> itemConsumer) {
        frodo.getInventory().add(ring);
        itemConsumer.accept(ring);
    }

    public void removeItem(Character frodo, Predicate<Item> itemFilter) {
        frodo.getInventory().removeIf(itemFilter);
    }

    public void updateItem(Character frodo, Predicate<Item> itemFilter, Function<Item, Item> itemFunction) {
        frodo.getInventory().stream()
                .filter(itemFilter)
                .forEach(item -> item.setValue(itemFunction.apply(item).getValue()));
    }
}
