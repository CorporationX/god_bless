package faang.school.godbless.LordOfTheRingsRPG;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Character {
    private List<Item> inventory = new ArrayList<>();

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Predicate<Item> condition) {
        inventory.removeIf(condition);
    }

    public void updateItem(Predicate<Item> filter, Function<Item, Item> updater) {
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (filter.test(item)) {
                inventory.set(i, updater.apply(item));
                break;
            }
        }
    }
}
