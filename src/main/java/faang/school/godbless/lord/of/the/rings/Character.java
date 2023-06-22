package faang.school.godbless.lord.of.the.rings;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private final String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public List<Item> getInventory() {
        return inventory;
    }
}
