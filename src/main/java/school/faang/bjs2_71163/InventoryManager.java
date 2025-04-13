package school.faang.bjs2_71163;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        if (character == null) {
            throw new IllegalArgumentException("character is null");
        }
        if (!character.getItems().add(item)) {
            throw new NoSuchElementException(String.format("Item %s already exists", item.name()));
        } else {
            itemConsumer.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> ifContains) {
        if (character == null) {
            throw new IllegalArgumentException("character is null");
        }
        character.getItems().removeIf(ifContains);
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
        if (character == null) {
            throw new IllegalArgumentException("character is null");
        }
        Iterator<Item> itemIterator = character.getItems().iterator();
        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            if (itemPredicate.test(item)) {
                itemIterator.remove();
                character.getItems().add(itemFunction.apply(item));
            }
        }
    }
}
