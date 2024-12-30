package school.faang.sprint_4.task_50036;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Player {
    private static final int EXPERIENCE_TO_LEVEL_UP = 100;

    private String name;
    private int level;
    private int experience;

    public void addExperience(int experience) {
        this.experience += experience;
        levelUp();
    }

    public void levelUp() {
        this.level += this.experience / EXPERIENCE_TO_LEVEL_UP;
    }


}

