package school.faang.bsj2_90800;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final String name;
    List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
