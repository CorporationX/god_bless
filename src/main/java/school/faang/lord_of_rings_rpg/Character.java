package school.faang.lord_of_rings_rpg;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final String NAME;
    private final List<Item> INVENTORY = new ArrayList<>();

    public Character(String NAME) {
        this.NAME = NAME;
    }
}