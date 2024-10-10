package school.faang.lord.of.the.rings;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }
        this.name = name;
    }

    public List<Item> getInventory() {
        return new ArrayList<>(inventory);
    }

    public void addItem(Item item) {
        validateItem(item);
        inventory.add(item);
    }

    public void removeItem(Item item) {
        validateItem(item);
        inventory.remove(item);
    }

    public void updateItem(Predicate<Item> updateCondition, Function<Item, Item> itemModifier) {
        for (int i = 0; i < inventory.size(); i++) {
            if (updateCondition.test(inventory.get(i))) {
                inventory.set(i, itemModifier.apply(inventory.get(i)));
            }
        }
    }

    private static void validateItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item не может быть null");
        }
    }
}
