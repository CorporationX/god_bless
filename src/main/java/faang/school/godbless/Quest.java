package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Quest {
    private String name;
    private int difficulty;
    private int reward;

    public int getDifficulty() {
        return this.difficulty;
    }

    public int getReward() {
        return this.reward;
    }
}
