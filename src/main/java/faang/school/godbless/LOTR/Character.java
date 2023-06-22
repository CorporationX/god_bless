package faang.school.godbless.LOTR;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        if (this.inventory == null) {
            this.inventory = new ArrayList<>();
        }
        this.name = name;
    }

    public void updateItem(int index,Item item) {
        this.inventory.remove(index);
        this.inventory.add(index, item);
    }
}
