package school.faang.task_49971;

import lombok.Getter;
import school.faang.exception.CheckException;

@Getter
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;

    public Quest(String name, int difficulty, int reward) {
        if (name == null || name.isEmpty()) {
            throw new CheckException("questName");
        }

        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}
