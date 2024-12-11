package school.faang.task_45544;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Character {
    private final String name;
    private final Set<Item> inventory = new HashSet<>();

    public Character(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.EMPTYFIELD.getValue(), "name of character"));
        }

        this.name = name;
    }
}
