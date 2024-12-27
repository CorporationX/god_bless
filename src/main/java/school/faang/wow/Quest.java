package school.faang.wow;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Quest {
    private String name;
    private int difficulty;
    private int reward;

    public Quest(String name, int difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}
