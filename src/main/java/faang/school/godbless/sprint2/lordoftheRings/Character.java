package faang.school.godbless.sprint2.lordoftheRings;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public void setItemInInventory(Item item) {
        this.inventory.add(item);

    }

}
