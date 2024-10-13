package school.faang.BJS2_33785;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<Item>();

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}
