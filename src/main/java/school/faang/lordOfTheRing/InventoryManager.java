package school.faang.lordOfTheRing;


import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class InventoryManager {

    public void addItem (Character character, Item item, Consumer<Item> consumerAddItem) {
        character.addItem(item);
        consumerAddItem.accept(item);
    }

    public void removeItem (Character character, Predicate<Item> predicateRemove){
        character.removeItem(predicateRemove);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updateFunction){

        List<Item> inventory = character.getInventory();

        for (int i = 0; i < character.getInventory().size(); i++) {

            Item item = character.getInventory().get(i);

            if (condition.test(item)) {
                Item updatedItem = updateFunction.apply(item);
                inventory.set(i, updatedItem);
            }
        }
    }
}
