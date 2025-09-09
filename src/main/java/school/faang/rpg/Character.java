package school.faang.rpg;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this(name, new ArrayList<>());
    }
}
