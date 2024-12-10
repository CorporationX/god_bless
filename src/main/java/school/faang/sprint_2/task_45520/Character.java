package school.faang.sprint_2.task_45520;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.inventory = new ArrayList<>();
        this.name = name;
    }
}
