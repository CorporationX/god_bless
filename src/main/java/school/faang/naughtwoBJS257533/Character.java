package school.faang.naughtwoBJS257533;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        checkName(name);
        this.name = name;
    }

    private void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException("Name cannot be 'null' or empty.");
        }
    }
}
