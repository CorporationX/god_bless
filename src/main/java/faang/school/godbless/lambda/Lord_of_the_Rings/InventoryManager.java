package faang.school.godbless.lambda.Lord_of_the_Rings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action){
        character.getInventory().add(item);
        action.accept(item);
    }
    public void removeItem(Character character, Predicate<Item> condition){
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater){
        var inventory = character.getInventory();
        inventory.forEach(item -> {
            if(condition.test(item)){
                inventory.set(inventory.indexOf(item), updater.apply(item));
            }
        });
    }
}
