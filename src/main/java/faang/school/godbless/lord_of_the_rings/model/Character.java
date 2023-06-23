package faang.school.godbless.lord_of_the_rings.model;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    public List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory.toString() +
                '}';
    }
}
