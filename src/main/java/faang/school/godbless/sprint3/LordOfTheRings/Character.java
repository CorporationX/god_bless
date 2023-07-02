package faang.school.godbless.sprint3.LordOfTheRings;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
