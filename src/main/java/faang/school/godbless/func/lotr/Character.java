package faang.school.godbless.func.lotr;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {

    private final String name;
    private final List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}
