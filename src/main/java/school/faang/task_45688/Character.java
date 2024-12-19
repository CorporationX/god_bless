package school.faang.task_45688;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public Character(String name, List<Item> inventory) {
        this.name = name;
        this.inventory = inventory;
    }
}
