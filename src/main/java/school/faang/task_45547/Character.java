package school.faang.task_45547;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;


public class Character {
    private final @NonNull String name;
    @Getter
    private final List<Item> inventory;

    public Character(@NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
        this.inventory = new ArrayList<>();
    }

}
