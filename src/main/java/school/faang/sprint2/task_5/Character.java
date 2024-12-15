package school.faang.sprint2.task_5;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.setName(name);
        inventory = new ArrayList<>();
    }
}
