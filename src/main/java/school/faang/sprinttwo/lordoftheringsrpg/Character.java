package school.faang.sprinttwo.lordoftheringsrpg;

import lombok.Data;

import java.util.List;

@Data
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
    }
}