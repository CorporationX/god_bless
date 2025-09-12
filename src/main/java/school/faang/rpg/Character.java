package school.faang.rpg;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
