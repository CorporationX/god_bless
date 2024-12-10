package school.faang.task_45555.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Setter
public class Character {
    private final String name;
    private List<Item> inventory;

    public Character(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}
