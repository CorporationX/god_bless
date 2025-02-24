package school.faang.sprint4.bjs2_63654;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public Player(@NonNull String name) {
        if (name.isBlank()) {
            String errorMessage = "Имя персонажа не может быть пустым";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        this.name = name;
        this.level = 1;
        this.experience = 0;
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }
}
