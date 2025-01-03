package school.faang.bjs250114;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Player {
    private final String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        if (name == null || name.trim().isEmpty()) {
            log.error("Name cannot be null or empty");
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (level < 0 || experience < 0) {
            log.error("Level or Experience cannot be negative");
            throw new IllegalArgumentException("Level or Experience cannot be negative");
        }
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }
}