package faang.school.godbless.sprint_2.functional_interface.task_17_hogwarts.task_23_lotr;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private final List<Item> inventory;
    private String name;

    public Character(String name) {
        this.name = name;
        inventory = new ArrayList<>();
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }


}
