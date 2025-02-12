package school.faang.task_57407;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final String name;
    private final List<Item> inventory;

    public Character(String name) {
        this.inventory = new ArrayList<>();
        this.name = name;
    }
}
