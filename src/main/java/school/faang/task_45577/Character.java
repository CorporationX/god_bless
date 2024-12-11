package school.faang.task_45577;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public List<Item> getInventory() {
        return inventory;
    }

}
