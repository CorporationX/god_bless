package school.faang.task_50708;

import lombok.Data;

@Data
public class Task {
    private String name;
    private int difficulty;
    private int reward;

    public Task(String name, int difficulty, int reward) {
        this.name = name;
        if (difficulty >= 0 && difficulty < 6) {
            this.difficulty = difficulty;
        }
        if (reward >= 0) {
            this.reward = reward;
        }
    }
}
