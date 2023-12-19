package faang.school.godbless.lor;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<String> itemConsumer) {
        List<Item> inventory = character.getInventory();
        inventory.add(item);
        character.setInventory(inventory);
        itemConsumer.accept(item.getName());
    }

    public void removeItem(Character character, Item item, Predicate<Item> itemPredicate) {
        List<Item> inventory = character.getInventory();
        if (itemPredicate.test(item)) {
            inventory.remove(item);
            character.setInventory(inventory);
        }
    }

    public void updateItem(Character character, Item item, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
        List<Item> inventory = character.getInventory();

        if (itemPredicate.test(item)) {
            itemFunction.apply(item);
        }
    }
}
