package derschrank.sprint04.task02.bjstwo_50097;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private static final int EXPERIENCE_BY_LEVEL = 1000;
    private final String name;
    private int level;
    private int experience;

    public synchronized void addExperience(int delta) {
        int levelup = (experience += delta) / EXPERIENCE_BY_LEVEL;
        if (levelup > 0) {
            System.out.println(name
                    + " has level up from "
                    + level + " to: " + (level += levelup));
        }
        experience %= EXPERIENCE_BY_LEVEL;
    }

    @Override
    public String toString() {
        return String.format("%s [level: %d, experience: %d]", name, level, experience);
    }
}
