package faang.school.godbless.lotr;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);

    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
        character.getInventory()
                .stream()
                .filter(itemPredicate)
                .forEach(item -> {
                    int indexItemInInventory = character.getInventory().indexOf(item);
                    character.getInventory().set(indexItemInInventory, itemFunction.apply(item));
                });
    }
}