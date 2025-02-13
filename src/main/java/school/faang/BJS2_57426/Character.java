package school.faang.BJS2_57426;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {

    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public Character(@NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }
}
