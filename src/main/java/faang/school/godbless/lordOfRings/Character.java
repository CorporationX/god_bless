package faang.school.godbless.lordOfRings;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    public String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }
}
