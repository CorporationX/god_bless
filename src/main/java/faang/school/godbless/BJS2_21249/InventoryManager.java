package faang.school.godbless.BJS2_21249;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (!item.getName().isBlank() && item.getValue() > 0) {
            int itemCount = character.getItemCounter();
            character.getInventory().add(itemCount, item);

            character.getInventoryMap().put(item, itemCount++);
            character.setItemCounter(itemCount);

            consumer.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> characterInventory = new ArrayList<>(character.getInventory());
        for (Item item : characterInventory) {
            if (predicate.test(item)) {
                character.getInventory().remove(character.getInventoryMap().get(item).intValue());
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                character.getInventory().set(character.getInventoryMap().get(item), function.apply(item));
            }
        }
    }
}
