package school.faang.invetory;

import lombok.Data;
import java.util.List;

@Data
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name, List<Item> inventory) {
        this.name = name;
        this.inventory = inventory;
    }
}
