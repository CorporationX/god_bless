package LordOfRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer){
        character.inventory.add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate){
        character.getInventory().removeIf(itemPredicate);
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction){
        character.getInventory().stream()
                .filter(itemPredicate)
                .findFirst()
                .ifPresent(a -> character.getInventory().
                        set(character.getInventory().indexOf(a),itemFunction.apply(a)));
    }
}
