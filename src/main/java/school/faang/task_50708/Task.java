package school.faang.task_50708;

import lombok.Data;

@Data
public class Task {
    private String name;
    private int difficulty;
    private int reward;
    private static final int HARD_DIFFICULTY = 6;
    private static final int EASY_DIFFICULTY = 0;

    public Task(String name, int difficulty, int reward) {
        this.name = name;

        if (difficulty < 0) {
            this.difficulty = EASY_DIFFICULTY;
        } else if (difficulty >= 6) {
            this.difficulty = HARD_DIFFICULTY;
        } else {
            this.difficulty = difficulty;
        }

        if (reward >= 0) {
            this.reward = reward;
        }
    }
}
