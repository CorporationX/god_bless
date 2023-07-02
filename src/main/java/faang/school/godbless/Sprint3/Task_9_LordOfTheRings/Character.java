package faang.school.godbless.Sprint3.Task_9_LordOfTheRings;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public List<Item> getInventory() {
        return inventory;
    }
}
