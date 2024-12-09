package school.faang.sprint2.task_45534;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@AllArgsConstructor
@ToString
public class Character {
    @NonNull
    private final String name;
    private final List<Item> items = new ArrayList<>();

    public void addItem(@NonNull Item item, @NonNull Consumer<Item> consumer) {
        items.add(item);
        consumer.accept(item);
    }

    public void removeItem(@NonNull Predicate<Item> filter) {
        if (!items.removeIf(filter)) {
            System.out.println("There is no such element");
        }
    }

    public void updateItem(@NonNull Predicate<Item> filter, @NonNull Function<Item, Item> updater) {
        items.replaceAll((item) -> filter.test(item) ? updater.apply(item) : item);
    }

    public void printAllItems() {
        System.out.println(name + " inventory:");
        items.stream().forEach(System.out::println);
    }
}
