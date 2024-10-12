package lordOfTheRingsRpg;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class Character {
    private String name;
    private final List<Item> inventory = new ArrayList<Item>();

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

}
