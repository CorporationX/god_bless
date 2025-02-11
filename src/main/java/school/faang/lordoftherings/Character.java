package school.faang.lordoftherings;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {
    private String name;
    private int level;
    private final List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.inventory = new ArrayList<>();
    }
}
