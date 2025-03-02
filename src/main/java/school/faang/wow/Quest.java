package school.faang.wow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Quest {
    String name;
    int difficulty;
    int reward;

    public Quest(String name, int difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}