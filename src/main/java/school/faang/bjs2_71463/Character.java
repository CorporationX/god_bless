package school.faang.bjs2_71463;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Character {
    private final String name;
    private final List<Item> inventory;

    public Character(String name) {
        this.name = name;
        inventory = new LinkedList<>();
    }
}
