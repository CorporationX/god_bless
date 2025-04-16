package school.faang.bjs2_70001;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
@RequiredArgsConstructor
public class Character {
    private final String name;
    private List<Item> inventory = new ArrayList<>();

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Predicate<Item> filter) {
        inventory.removeIf(filter);
    }

    public void updateItem(Predicate<Item> filter, Function<Item, Item> update) {
        for (int i = 0; i < inventory.size(); i++) {
            if (filter.test(inventory.get(i))) {
                inventory.set(i, update.apply(inventory.get(i)));
            }
        }
    }
}
