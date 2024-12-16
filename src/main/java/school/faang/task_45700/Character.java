package school.faang.task_45700;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    public String name;
    @Setter
    public List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void addInventory(Item item) {
        this.inventory.add(item);
    }
}
