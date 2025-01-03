package school.faang.task_51160;

import lombok.Data;

@Data
public class Task {
    private String name;
    private int difficulty;
    private int reward;

    public Task(String name, int difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}
