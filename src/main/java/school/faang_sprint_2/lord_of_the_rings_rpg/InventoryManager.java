package school.faang_sprint_2.lord_of_the_rings_rpg;

import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        character.getInventory().forEach(item -> {
            if (predicate.test(item)) {
                item.setPrice(function.apply(item).getPrice());
            }
        });
    }
}
