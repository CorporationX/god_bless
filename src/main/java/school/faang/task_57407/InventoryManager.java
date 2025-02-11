package school.faang.task_57407;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
@AllArgsConstructor
public class InventoryManager {
    public void addItem( Character character,Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }
    public void removeItem( Character character, Predicate<Item> predicate ) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                character.getInventory().remove(item);
            }
        }
    }
    public void updateItem(Character character, Predicate<Item> predicate , Function<Item,Item> function) {
        List<Item> items = character.getInventory();
        for (int i = 0; i < items.size(); i++) {
            if (predicate.test(items.get(i))) {
                items.set(i,function.apply(items.get(i)));
            }
        }

    }


}
