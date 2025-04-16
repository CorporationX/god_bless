package school.faang.bjs2_70032;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
public class Character {
    private final String name;
    private final List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public List<Item> addInventoryItem(Item item) {
        inventory.add(item);
        return inventory;
    }

    public boolean removeItem(Predicate<Item> filter) {
        return inventory.removeIf(filter);
    }

    public Item updateItem(Predicate<Item> filter, Function<Item, Item> converter) {
        return inventory.stream()
                .filter(filter)
                .findFirst()
                .map(converter)
                .orElseThrow(() -> new NoSuchElementException("No items fulfill the condition"));
    }
}