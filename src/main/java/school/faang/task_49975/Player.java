package school.faang.task_49975;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private static final int LEVEL_MULTIPLIER = 100;

    private final String name;
    private int level;
    private int experience;

    public synchronized void addExperience(int experience) {
        this.experience += experience;
        calculateLevel();
    }

    private synchronized void calculateLevel() {
        this.level = experience / LEVEL_MULTIPLIER;
    }
}