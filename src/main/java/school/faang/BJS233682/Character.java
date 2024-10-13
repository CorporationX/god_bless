package school.faang.BJS233682;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
public class Character {
    private final String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(item.getName() + " был добавлен в инвентарь.");
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

    public void displayInventory() {
        for (Item item : inventory) {
            System.out.println(item.getName() + ": " + item.getValue());
        }
    }
}
