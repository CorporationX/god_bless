package school.faang.sprint.second.rpg;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    @NonNull
    private String name;
    private List<Item> inventory;

    public Character(@NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Character name cannot be blank");
        }

        this.name = name;
        this.inventory = new ArrayList<>();
    }
}
