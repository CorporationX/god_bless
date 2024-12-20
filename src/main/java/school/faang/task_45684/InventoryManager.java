package school.faang.task_45684;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    protected void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    protected void removeItem(Character character, Predicate<Item> predicate) {
        if (character.getInventory().isEmpty()) {
            System.out.println("Инвентарь пуст, удаление невозможно.");
            return;
        }
        character.getInventory().removeIf(predicate);
    }

    protected void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        character.getInventory().replaceAll(item -> condition.test(item) ? updater.apply(item) : item);
    }
}
