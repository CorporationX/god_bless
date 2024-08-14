package faang.school.godbless.LordOfTheRings;

import java.util.ArrayList;
import java.util.List;

public class Character {
    String name;
    List<Item> inventory = new ArrayList<>();
    public Character(String name) {
        this.name = name;
    }
}
