package faang.school.godbless.lordOfTheRings;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(@NonNull String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}
