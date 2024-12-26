package school.faang.task_50016;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final static int XP_LEVELUP = 500;

    private String name;
    private int level;
    private int experience;

    public void addExperience(int experience) {
        this.experience += experience;
    }

    public void addLevel() {
        if (experience >= XP_LEVELUP) {
            level++;
            experience = experience - XP_LEVELUP;
        }
    }
}
