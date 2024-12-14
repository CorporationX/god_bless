package school.faang.task_45658;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Item item, Character character, Consumer<Item> action) {
        character.getItemList().add(item);
        action.accept(item);
    }

    public void removeItem(Item item, Character character,  Predicate<Item> condition) {
        character.getItemList().removeIf(condition);
    }

    public void updateItem(Character character, Function<Item, Item> updateFunction, Predicate<Item> condition) {
        List<Item> list = character.getItemList();

        for (int i = 0; i < list.size(); i++) {
            Item item = list.get(i);
            if (condition.test(item)) {
                list.set(i, updateFunction.apply(item));
            }
        }
    }

}
