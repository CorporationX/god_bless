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

    public void removeItem(Character character, Predicate<Item> predicate) {
        boolean isFound = false;
        for (Item item : character.inventory) {
            if (predicate.test(item)) {
                character.inventory.remove(item);
                isFound = true;
                break;
            }
        }
        if (!isFound) throw new IllegalArgumentException("item not found");
    }

    public void updateItem(Character character, Predicate<Item> predicate,
                           Function<Item, Item> function) {
        boolean isFound = false;
        for (Item item : character.inventory) {
            if (predicate.test(item)) {
                item = function.apply(item);
                System.out.println(item);
                isFound = true;
                break;
            }
        }
        if (!isFound) throw new IllegalArgumentException("item not found");
    }

}
