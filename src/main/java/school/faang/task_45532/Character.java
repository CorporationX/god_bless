package school.faang.task_45532;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class Character {
    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    private List<Item> inventory;
    private final String name;

}
