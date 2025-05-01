package school.faang.tournament_of_the_three_wizards;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private String name;
    private int difficulty;
    private int reward;

    public Task(String name, int difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }

    public int completeTask() {
        return reward;
    }
}
