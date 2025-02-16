package school.faang.lord_of_rings;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        Objects.requireNonNull(character, "Character could't be null");
        Objects.requireNonNull(item, "Item could't be null");
        Objects.requireNonNull(itemConsumer, "ItemConsumer could't be null");

        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        Objects.requireNonNull(character, "Character could't be null");
        Objects.requireNonNull(itemPredicate, "ItemPredicate could't be null");

        character.getInventory().removeIf(itemPredicate);
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Integer> itemFunction) {
        Objects.requireNonNull(character, "Character could't be null");
        Objects.requireNonNull(itemPredicate, "ItemPredicate could't be null");
        Objects.requireNonNull(itemFunction, "ItemFunction could't be null");

        character.getInventory().stream().filter(itemPredicate).forEach(item ->
                item.setValue(itemFunction.apply(item)));
    }
}
