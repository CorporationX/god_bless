package school.faang.sprint_2.bjs2_33712;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class Character {
    @Getter
    private final String name;
    private final Set<Item> inventory;

    Character(String name) {
        this.name = name;
        this.inventory = new HashSet<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Predicate<Item> predicate) {
        inventory.removeIf(predicate);
    }

    public Set<Item> getInventory() {
        return Set.copyOf(inventory);
    }
}
