package school.faang.sprint_2.task_45665;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final List<Item> inventory;
    private final String name;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }
}
