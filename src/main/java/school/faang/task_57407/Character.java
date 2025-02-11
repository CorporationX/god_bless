package school.faang.task_57407;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter

public class Character {
    private final String name;
    private  List<Item> inventory;

    public Character(String frodo) {
        this.name = frodo;
    }
}
