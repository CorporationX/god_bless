package faang.school.godbless.task_23_lotr;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer){
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function){
        List<Item> inventory = character.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);

            if (predicate.test(item)){
                item = function.apply(item);
            }
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate){
        List<Item> inventory = character.getInventory();

        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);

            if (predicate.test(item)){
                character.removeItem(item);
            }
        }
    }
}
