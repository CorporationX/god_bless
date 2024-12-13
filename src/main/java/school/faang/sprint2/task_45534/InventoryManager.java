package school.faang.sprint2.task_45534;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class InventoryManager {
    @NonNull
    private final Character character;

    public void addItem(@NonNull Item item, @NonNull Consumer<Item> consumer) {
        character.getItems().add(item);
        consumer.accept(item);
    }

    public void removeItem(@NonNull Predicate<Item> filter) {
        boolean removed = character.getItems().removeIf(filter);
        if (!removed) {
            System.out.println("There is no such element");
        }
    }

    public void updateItem(@NonNull Predicate<Item> filter, @NonNull Function<Item, Item> updater) {
        List<Item> items = character.getItems();
        items.replaceAll((item) -> filter.test(item) ? updater.apply(item) : item);
    }

    public void printAllItems() {
        System.out.println(character.getName() + " inventory:");
        character.getItems().forEach(System.out::println);
    }
}
