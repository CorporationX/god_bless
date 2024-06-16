package faang.school.godbless.BJS29199;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        inventory = new ArrayList<Item>();
    }
}
