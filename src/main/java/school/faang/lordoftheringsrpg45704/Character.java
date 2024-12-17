package school.faang.lordoftheringsrpg45704;

import lombok.NoArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }
}