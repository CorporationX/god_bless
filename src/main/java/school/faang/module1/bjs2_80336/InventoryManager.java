package school.faang.module1.bjs2_80336;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        validateCharacter(character);
        validateItem(item);
        if (action == null) {
            throw new IllegalArgumentException("Action (Consumer<Item>) не может быть null.");
        }
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        validateCharacter(character);
        if (filter == null) {
            throw new IllegalArgumentException("Фильтр (Predicate<Item>) не может быть null.");
        }
        character.getInventory().removeIf(filter);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updater) {
        validateCharacter(character);
        if (filter == null) {
            throw new IllegalArgumentException("Фильтр (Predicate<Item>) не может быть null.");
        }
        if (updater == null) {
            throw new IllegalArgumentException("Функция обновления (Function<Item, Item>) не может быть null.");
        }
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (filter.test(item)) {
                inventory.set(i, updater.apply(item));
            }
        }
    }

    private void validateCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Персонаж не может быть null.");
        }
        if (character.getName() == null || character.getName().isBlank()) {
            throw new IllegalArgumentException("Имя персонажа не может быть пустым.");
        }
        if (character.getInventory() == null) {
            throw new IllegalArgumentException("Инвентарь персонажа не может быть null.");
        }
    }

    private void validateItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Предмет не может быть null.");
        }
        if (item.getName() == null || item.getName().isBlank()) {
            throw new IllegalArgumentException("Имя предмета не может быть пустым.");
        }
        if (item.getValue() < 0) {
            throw new IllegalArgumentException("Стоимость предмета не может быть отрицательной.");
        }
    }
}