package faang.school.godbless.sprint2.lordoftheRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer consumer) {
        character.setItemInInventory(item);
        consumer.accept(item.getName());
    }
    public void removeItem(Character character, Predicate<Item> itemPredicate){
       character.getInventory().removeIf(itemPredicate);
    }
    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> updateFunction) {
        character.getInventory().stream()
                .filter(itemPredicate)
                .findFirst()
                .ifPresent(f -> character.getInventory().set(character.getInventory().indexOf(f), updateFunction.apply(f)));

    }
}
