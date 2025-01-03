package school.faang.sprint_4.task_50172;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExperience(int exp) {
        experience += exp;
    }
}
