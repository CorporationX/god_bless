package faang.school.godbless.lor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<String> itemConsumer) {
        List<Item> inventory = character.getInventory();

        if (!inventory.contains(item)) {
            inventory.add(item);
        } else {
            item.setValue(item.getValue() + 1);
        }

        itemConsumer.accept(item.getName() + ": " + item.getValue());
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        List<Item> inventory = character.getInventory();

        inventory.removeIf(itemPredicate);
    }

    public void updateItem(Character character, Predicate<String> itemPredicate, Function<Item, Item> itemFunction) {
        List<Item> inventory = character.getInventory();

        for (Item item : inventory) {
            if (itemPredicate.test(item.getName())) {
                itemFunction.apply(item);
            }
        }
    }
}
