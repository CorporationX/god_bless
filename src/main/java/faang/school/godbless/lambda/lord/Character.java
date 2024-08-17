package faang.school.godbless.lambda.lord;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@ToString
public class Character {

    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Predicate<Item> predicate) {
        inventory.removeIf(predicate);
    }

    public void updateItem(Predicate<Item> predicate, Function<Item, Item> updater) {
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (predicate.test(item)) {
                inventory.set(i, updater.apply(item));
            }
        }
    }

    public void printInventory() {
        System.out.println("Inventory if " + name + ": " + inventory.size() + " items");
        inventory.forEach(x -> System.out.println("    " + x));
    }
}
