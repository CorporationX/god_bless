package faang.school.godbless.BJS2_21249;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (!item.getName().isBlank() && item.getValue() > 0) {
            character.getInventory().add(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf((item) -> predicate.test(item));
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (int i = 0; i < character.getInventory().size(); i++) {
            Item characterItem = character.getInventory().get(i);
            if (predicate.test(characterItem)) {
                character.getInventory().set(i, function.apply(characterItem));
            }
        }
    }
}
