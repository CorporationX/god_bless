package school.faang.sprint2.task_BJS2_57444;

import lombok.AllArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Predicate;

@AllArgsConstructor
public class InventoryManager {
    public void addItem(Character person, Item item, Consumer<Item> consumer) {
        checkCharacter(person);
        checkItem(item);
        checkConsumer(consumer);

        person.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character person, Predicate<Item> filter) {
        checkCharacter(person);
        checkPredicate(filter);

        person.getInventory().removeIf(filter);
    }

    public void updateItem(Character person, Predicate<Item> filter, Consumer<Item> updater) {
        checkCharacter(person);
        checkPredicate(filter);
        checkConsumer(updater);

        person.getInventory().stream().filter(filter).forEach(updater);
    }

    private void checkCharacter(Character person) {
        if (person == null) {
            throw new IllegalArgumentException("Персонаж не должен быть null");
        }
    }

    private void checkItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Предмет не должен быть null");
        }
    }

    private void checkConsumer(Consumer<Item> consumer) {
        if (consumer == null) {
            throw new IllegalArgumentException("Действие не должно быть null");
        }
    }

    private void checkPredicate(Predicate<Item> filter) {
        if (filter == null) {
            throw new IllegalArgumentException("Фильтр не должен быть null");
        }
    }
}
