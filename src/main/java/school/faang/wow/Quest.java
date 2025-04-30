package school.faang.wow;

import lombok.Getter;

@Getter
public class Quest {
    private final String name;
    private final DifficultyQuest difficulty;
    private final int reward;

    public Quest(String name, DifficultyQuest difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}