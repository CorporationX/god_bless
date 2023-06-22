package faang.school.godbless.lord_of_the_Rings_RPG;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private final List<Item> inventory = new ArrayList<>();

    public List<Item> getInventory() {
        return inventory;
    }
}
