package derschrank.sprint02.task05.bjstwo_45515;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Character {
    private final String name;
    private final Set<Item> inventory;

    public Character(String name) {
        this.name = name;
        inventory = new HashSet<>();
    }
}
