package faang.school.godbless.lambdas.lorrpg;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character == null || item == null || consumer == null) {
            throw new IllegalArgumentException();
        }

        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character == null || predicate == null) {
            throw new IllegalArgumentException();
        }

        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate,
                           Function<Item, Item> function) {

        if (character == null || predicate == null || function == null) {
            throw new IllegalArgumentException();
        }

        // Не нашел лучше решения для списка...
        // Получается либо проход всего списка, либо отсутствие индекса которое нужно для замены итема
        // Либо отходить от задания и менять сигнатуры
        List<Item> inventory = character.getInventory();
        Item item = null;
        int itemIndex = -1;
        for (int i = 0; i < inventory.size(); i++) {
            if (predicate.test(inventory.get(i))) {
                item = inventory.get(i);
                itemIndex = i;
                break;
            }
        }
        if (itemIndex == -1) {
            throw new IllegalStateException();
        }
        inventory.set(itemIndex, function.apply(item));
    }
}
