package school.faang.lordoftherings;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
