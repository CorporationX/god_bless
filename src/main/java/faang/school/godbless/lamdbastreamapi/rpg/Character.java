package faang.school.godbless.lamdbastreamapi.rpg;

import java.util.ArrayList;
import java.util.List;

public record Character(String name, List<Item> inventory) {


    public Character(String name) {
        this(name, new ArrayList<>());
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

}
