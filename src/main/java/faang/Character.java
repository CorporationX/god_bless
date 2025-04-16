package faang;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public void update(Predicate<Item> predicate, Function<Item, Item> itemFunction) {
        Optional<Item> targetItem = items.stream()
                .filter(predicate)
                .findFirst();

        if (targetItem.isPresent()) {
            items.remove(targetItem.get());
            items.add(itemFunction.apply(targetItem.get()));
        }
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
