package school.faang.task_49971;

import lombok.Getter;
import school.faang.exception.CheckException;

@Getter
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public Player(String name, int level, int experience) {
        if (name == null || name.isEmpty()) {
            throw new CheckException("playerName");
        }

        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }
}
