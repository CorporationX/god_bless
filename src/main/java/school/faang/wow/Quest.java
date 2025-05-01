package school.faang.wow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Quest {

    private final String name;
    private int difficulty;
    private int reward;

    public Quest(String name, int difficulty, int reward) {
        this.difficulty = difficulty;
        this.name = name;
        this.reward = reward;
    }

    public int getRewardExp() {
        return reward;
    }
}
