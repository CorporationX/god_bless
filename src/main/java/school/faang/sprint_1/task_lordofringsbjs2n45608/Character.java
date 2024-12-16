package school.faang.sprint_1.task_lordofringsbjs2n45608;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        if (name != null) {
            this.name = name;
            this.inventory = new ArrayList<>();
        }
    }

    public void addItem(Item item) {
        if (item != null) {
            inventory.add(item);
        }
    }
}
