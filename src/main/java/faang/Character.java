package faang;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Getter
public class Character {
    private final String name;
    private final List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Predicate<Item> predicate) {
        items.removeIf(predicate);
    }

    public void update(Predicate<Item> predicate, Function<Item, Item> updater) {
        for (int i = 0; i < items.size(); i++) {
            Item targetItem = items.get(i);

            if (predicate.test(targetItem)) {
                items.set(i, updater.apply(targetItem));
            }
        }
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
