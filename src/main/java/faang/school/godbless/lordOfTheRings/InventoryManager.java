package faang.school.godbless.lordOfTheRings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        consumer.andThen(add -> character.getInventory().add(item)).accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
        // before shorten
//        character.getInventory().removeIf(item -> predicate.test(item));
    }


    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();
        for(Item item : inventory){
            if (predicate.test(item)){
                Item updatedItem = function.apply(item);
                inventory.set(inventory.indexOf(item),updatedItem);
                break;
            }
        }
    }
}
