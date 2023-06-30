package faang.school.godbless.sprint_3.lord_of_the_rings_RPG;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
