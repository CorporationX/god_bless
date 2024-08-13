package faang.school.godbless.lord.of.rings.rpg;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
    }
}
