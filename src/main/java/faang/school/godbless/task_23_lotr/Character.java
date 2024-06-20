package faang.school.godbless.task_23_lotr;

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
