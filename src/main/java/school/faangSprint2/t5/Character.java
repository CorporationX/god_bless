package school.faangSprint2.t5;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}