package faang.school.godbless.LordOfTheRingsRPG;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }


}
