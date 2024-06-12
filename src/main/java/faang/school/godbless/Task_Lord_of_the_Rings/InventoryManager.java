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
        int j = character.inventory.size();
        boolean found = false;
        for (int i=0; i<j; i++) {
            if (predicate.test(character.inventory.get(i))) {
                found = true;
                character.inventory.set(i,function.apply(character.inventory.get(i)));
                break;
            }
        }
        if (!found) System.out.println("we didn't find this...");
    }

}
