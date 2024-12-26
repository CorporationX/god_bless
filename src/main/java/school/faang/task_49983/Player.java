package school.faang.task_49983;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private int level;
    private int experience;

    public void increaseExperience(int reward) {
        experience += reward;
    }
}
