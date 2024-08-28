package faang.school.godbless.BJS2_24893;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
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
