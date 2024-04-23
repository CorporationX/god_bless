package triwizardTournament;

import lombok.Data;

@Data
public class Task {
    private String name;
    private int difficulty;
    private int reward;

    public Task(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = difficulty * 50;
    }
}
