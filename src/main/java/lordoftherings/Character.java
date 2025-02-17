package lordoftherings;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        Objects.requireNonNull(name, "Character name cannot be null");
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}
