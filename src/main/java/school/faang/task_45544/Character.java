package school.faang.task_45544;

import lombok.Getter;
import school.faang.task_45544.exception.CheckException;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Character {
    private final String name;
    private final Set<Item> inventory = new HashSet<>();

    public Character(String name) {
        if (name == null || name.isEmpty()) {
            throw new CheckException("name of character");
        }

        this.name = name;
    }
}
