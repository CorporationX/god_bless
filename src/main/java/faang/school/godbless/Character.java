package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private List<Item> inventory = new ArrayList<>();
    private String name;

    public List<Item> getInventory() {
        return this.inventory;
    }

    public Character(String name) {
        this.name = name;
    }
}
