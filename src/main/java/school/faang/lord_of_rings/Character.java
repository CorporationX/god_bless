package school.faang.lord_of_rings;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<Item>();
    }
}
