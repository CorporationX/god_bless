package school.faang.bjs2_92858;

import lombok.Getter;

@Getter
public class Task {
    private final String name;
    private final int difficulty;
    private final int maxDifficulty = 10;
    private final int reward;
    private final int maxReward = 1000;

    public Task(String name, int difficulty, int reward) {
        this.name = DataValidator.requireNotBlank(name);
        this.difficulty = DataValidator.requirePositiveAndRange(difficulty, maxDifficulty);
        this.reward = DataValidator.requirePositiveAndRange(reward, maxReward);
    }
}
