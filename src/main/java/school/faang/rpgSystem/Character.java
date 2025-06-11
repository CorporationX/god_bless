package school.faang.rpgSystem;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private String name;
    private List<Item> items = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
