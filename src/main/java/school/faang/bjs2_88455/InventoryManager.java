package school.faang.bjs2_88455;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Item item, Consumer<Item> consumerAdd) {
        consumerAdd.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicateFilter) {
        ArrayList<Item> listForRemove = new ArrayList<>();
        character.getInventory().forEach(item -> {
            if (predicateFilter.test(item)) {
                System.out.printf("%s - item has been tested\n", item);
            } else {
                listForRemove.add(item);
                System.out.printf("%s - the item was dropped from inventory\n", item);
            }
        });
        character.getInventory().removeAll(listForRemove);
    }

    public void updateItem(Character character, Consumer<Item> consumerUpdate) {
        character.getInventory().forEach(item -> {
            consumerUpdate.accept(item);
        });
    }

    public void printAllItems(Character character, Consumer<ArrayList<Item>> consumer) {
        System.out.printf("All items %s-", character.getName());
        consumer.accept(character.getInventory());
    }
}
