package school.faang.task_45693;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class Character {

    private final String name;
    List<Item> inventory;

    public Character(String name) {
        this.name = name;
    }

}
