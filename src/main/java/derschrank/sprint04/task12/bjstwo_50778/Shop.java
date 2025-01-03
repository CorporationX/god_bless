package derschrank.sprint04.task12.bjstwo_50778;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shop implements ProviderItemsInterface {
    private final List<Item> items;

    public Shop() {
        items = new ArrayList<>();
    }

    @Override
    public synchronized void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    @Override
    public synchronized Optional<Item> getItem(int index) {
        if (index < items.size()) {
            return Optional.of(items.remove(index));
        }
        return Optional.empty();
    }

    @Override
    public synchronized List<Item> getListOfItems() {
        return new ArrayList<>(items);
    }

    public int getCountOfItems() {
        return items.size();
    }
}
