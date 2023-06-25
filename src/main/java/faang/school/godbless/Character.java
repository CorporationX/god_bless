package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private List<Item> inventory;

    public Character() {
        this.inventory = new ArrayList<>();
    }

    public List<Item> getInventory() {
        return inventory;
    }
}
