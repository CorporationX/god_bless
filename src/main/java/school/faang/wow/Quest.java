package school.faang.wow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Quest {

    private String name;
    private Difficulty difficulty;
    private int reward;

    public Quest(String name, Difficulty difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }

    public enum Difficulty {
        EASY, MEDIUM, HARD
    }
}
