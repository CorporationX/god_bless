package school.faang.sprint2.task45800.model;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
