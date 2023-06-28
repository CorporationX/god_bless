package faang.school.godbless.lord_of_the_rings.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory.toString() +
                '}';
    }

    public List<Item> getInventory() {
        return inventory;
    }

}
