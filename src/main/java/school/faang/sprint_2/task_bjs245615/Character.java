package school.faang.sprint_2.task_bjs245615;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    @NonNull
    private final String name;
    private final List<Item> inventory;

    public Character(@NonNull String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}
