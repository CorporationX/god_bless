package school.faang.lotr_rpg;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Character {
    private String name;
    private List<Item> items;

    Character(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }
}
