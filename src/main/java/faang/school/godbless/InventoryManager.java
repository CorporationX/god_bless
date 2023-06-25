package faang.school.godbless;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        character.getInventory().removeIf(itemPredicate);
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
        character.getInventory().forEach(item -> {
            if (itemPredicate.test(item)) {
              replaceNameAndValueItem(item, itemFunction.apply(item));
            }
        });
    }

    private void replaceNameAndValueItem(Item item, Item newItem) {
        item.setName(newItem.getName());
        item.setValue(newItem.getValue());
    }
}
