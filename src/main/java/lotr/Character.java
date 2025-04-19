package lotr;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {
    private String name;
    List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
