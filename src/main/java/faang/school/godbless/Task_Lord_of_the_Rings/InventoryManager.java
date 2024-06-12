package faang.school.godbless.Task_Lord_of_the_Rings;

import lombok.NoArgsConstructor;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@NoArgsConstructor
public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.addItemToInventory(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Item item, Predicate<Item> predicate) {
        if (predicate.test(item)) {
            character.removeItemFromInventory(item);
        }
    }

    public void updateItem(Character character, Item item,
                           Predicate<Item> predicate, Function<Item, Item> function) {
        this.removeItem(character, item, predicate);
        Item newItem = function.apply(item);
        character.addItemToInventory(newItem);
    }

}
