package lordrpg;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

public class InventoryManager {

    // Метод для добавления предмета в инвентарь
    public void addItem(Character character, Item item, Consumer<Item> action) {
        Objects.requireNonNull(item, "Item cannot be null");
        Objects.requireNonNull(character, "Character cannot be null");
        Objects.requireNonNull(action, "Action cannot be null");
        character.addItem(item);
        action.accept(item);  // выполняем дополнительное действие
    }

    // Метод для удаления предмета, если он удовлетворяет предикату
    public void removeItem(Character character, Predicate<Item> condition) {
        Objects.requireNonNull(condition,"Condition cannot be null");
        Objects.requireNonNull(character, "Character cannot be null");
        character.getInventory().removeIf(condition);
    }

    // Метод для обновления предмета в инвентаре с использованием функции
    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updateFunction) {
        Objects.requireNonNull(character, "Character cannot be null");
        Objects.requireNonNull(condition, "Condition cannot be null");
        Objects.requireNonNull(updateFunction, "Update function cannot be null");

        for (Item item : character.getInventory()) {
            if (condition.test(item)) {
                Item updatedItem = updateFunction.apply(item);
                character.removeItem(item);
                character.addItem(updatedItem);
                Objects.requireNonNull(updatedItem, "Update item cannot be null");
            }
        }
    }
}
