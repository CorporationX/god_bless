package school.faang.bjs2_90900;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character name, Item item, Consumer<Item> consumer) {
        name.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character name, Predicate<Item> removeItemPredicate) {
        name.getInventory().removeIf(removeItemPredicate);
    }

    public void updateItem(Character name, Predicate<Item> predicate, Function<Item, Item> function) {
        name.setInventory(name.getInventory().stream()
                .map(x -> predicate.test(x) ? function.apply(x) : x)
                .toList());
    }
}
