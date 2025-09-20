package school.faang.lord_of_the_rings_rpg_bjs2_87338;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        List<Item> updateInventory = character.getInventory().stream()
                .map(x -> condition.test(x) ? updater.apply(x) : x)
                .toList();
        character.setInventory(updateInventory);
    }
}


