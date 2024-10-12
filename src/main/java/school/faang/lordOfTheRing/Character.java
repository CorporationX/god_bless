package school.faang.lordOfTheRing;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Character {
    private String name;
    @Getter
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Predicate<Item> condition) {
        inventory.removeIf(condition);
    }

}
