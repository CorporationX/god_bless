package school.faang.task_50056;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private static final int LEVEL_UP = 1;
    private String name;
    private int level;
    private int experience;

    public void updateExperience(int gainedExperience) {
        experience += gainedExperience;
    }

    public void updateLevel() {
        level += LEVEL_UP;
    }
}
