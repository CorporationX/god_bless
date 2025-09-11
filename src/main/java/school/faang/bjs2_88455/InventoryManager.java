package school.faang.bjs2_88455;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumerAdd) {
        character.getInventory().add(item);
        consumerAdd.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicateFilter) {
        character.getInventory().removeIf(predicateFilter);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventory = new ArrayList<>();
        character.getInventory().stream().forEach(item -> {
            if (predicate.test(item)) {
                inventory.add(function.apply(item));
            } else {
                inventory.add(item);
            }

        });
        final int[] i = {0};
        inventory.forEach(item -> {
            character.getInventory().set(i[0], item);
            i[0]++;
        });
    }

    public void printAllItems(Character character, Consumer<ArrayList<Item>> consumer) {
        System.out.printf("All items %s-", character.getName());
        consumer.accept(character.getInventory());
    }
}
