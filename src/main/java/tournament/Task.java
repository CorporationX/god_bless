package tournament;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Task {
    private String name;
    private int difficulty;
    private int reward;

    public Task(String name, int difficulty, int reward) {
        this.difficulty = difficulty;
        this.name = name;
        this.reward = reward;
    }
}