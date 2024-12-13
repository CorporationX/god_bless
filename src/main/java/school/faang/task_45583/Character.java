package school.faang.task_45583;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}