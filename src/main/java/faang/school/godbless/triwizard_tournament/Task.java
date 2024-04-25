package faang.school.godbless.triwizard_tournament;

import lombok.Data;

@Data
public class Task {
    private String name;
    private String difficulty;
    private int reward;

    public Task(String name, int reward) {
        this.name = name;
        this.reward = reward;
    }
}
