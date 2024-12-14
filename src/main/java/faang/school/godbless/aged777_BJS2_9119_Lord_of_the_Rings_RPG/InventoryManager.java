package faang.school.godbless.aged777_BJS2_9119_Lord_of_the_Rings_RPG;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        for (int i = 0; i < character.inventory().size(); i++) {
            Item currentItem = character.inventory().get(i);
            if (predicate.test(currentItem)) character.inventory().remove(currentItem);
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventoryCopy = new ArrayList<>(character.inventory());

        for (Item currentCopyItem : inventoryCopy) {
            int originalItemIndex = inventoryCopy.indexOf(currentCopyItem);
            if (predicate.test(currentCopyItem)) character.inventory().set(originalItemIndex, function.apply(currentCopyItem));
        }

    }
}
