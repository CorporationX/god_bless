package school.faang.lotr_rpg;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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
        }

        int deleted = 0;
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (filter.test(item)) {
                iterator.remove();
                System.out.println("Удалён предмет: " + item.getName());
                deleted++;
            }
        }

        if (deleted == 0) {
            System.out.println("Предметы не найдены");
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updater) {
        for (Item item : character.getItems()) {
            if (predicate.test(item)) {
                int index = character.getItems().indexOf(item);
                character.getItems().set(index, updater.apply(item));
            }
        }
    }
}