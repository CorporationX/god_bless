package school.faang.bjs2_92878;

import lombok.Getter;

@Getter
public class Task {
    private final String name;
    private final Difficulty difficulty;
    private final int reward;

    public Task(String name, Difficulty difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = difficulty.getDifficultLevelPoints() * 2;
    }
}
