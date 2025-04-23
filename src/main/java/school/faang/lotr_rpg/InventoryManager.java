package school.faang.lotr_rpg;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {

    public void addItem(Item item, Character character, Consumer<Item> action) {
        character.getItems().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        Objects.requireNonNull(character, "Персонаж не может быть null");
        Objects.requireNonNull(filter, "Фильтр не может быть null");

        List<Item> items = character.getItems();
        if (items == null || items.isEmpty()) {
            System.out.println("Инвентарь пуст");
            return;
        }

        int initialSize = items.size();
        items.removeIf(item -> {
            if (filter.test(item)) {
                System.out.println("Удалён предмет: " + item.getName());
                return true;
            }
            return false;
        });

        if (items.size() == initialSize) {
            System.out.println("Предметы не найдены");
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updater) {
        if (character.getItems() != null) {
            List<Item> updatedItems = character.getItems().stream()
                    .map(item -> predicate.test(item) ? updater.apply(item) : item)
                    .collect(Collectors.toList());
            character.setItems(updatedItems);
        }
    }
}