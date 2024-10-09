package school.faang.BJS233632;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private String name;
    private List<Item> inventory;

    Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}
