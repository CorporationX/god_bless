package school.faang.task_50744;

import lombok.Getter;
import school.faang.exception.CheckException;

@Getter
public class Task {
    private final String name;
    private final int difficulty;
    private final int reward;

    public Task(String name, int difficulty, int reward) {
        if (name == null || name.isEmpty()) {
            throw new CheckException("taskName");
        }
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}
