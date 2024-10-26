package wow;

import lombok.Getter;

@Getter
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;

    public Quest(String name, int difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}
