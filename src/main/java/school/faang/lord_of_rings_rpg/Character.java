package school.faang.lord_of_rings_rpg;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String NAME) {
        this.name = NAME;
    }
}