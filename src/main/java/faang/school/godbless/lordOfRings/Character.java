package faang.school.godbless.lordOfRings;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {
    private List<Item> inventory = new ArrayList<>();
    private String name;

    public void setInventory(Item item) {
        inventory.add(item);
    }

    public Character(String name) {
        this.name = name;
    }
}
