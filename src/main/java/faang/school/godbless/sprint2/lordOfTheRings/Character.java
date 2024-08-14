package faang.school.godbless.sprint2.lordOfTheRings;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Character {
    private final String NAME;
    private List<Item> inventory = new ArrayList<>();

    public Character(String NAME) {
        this.NAME = NAME;
    }
}

