package school.faang.bjs2_57543;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Getter
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public Character(@NonNull String name) {
        if (name.isBlank()) {
            log.error("Попытка ввести пустое имя персонажа: {}", name);
            throw new IllegalArgumentException("Имя персонажа не может быть пустым");
        }
        this.name = name;
    }
}
