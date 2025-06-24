package school.faang.bjs2_82727;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class Task {
    private static final int MIN_REWARD = 300;
    private static final int MAX_REWARD = 500;
    private static final int MIN_DIFFICULTY = 5000;
    private static final int MAX_DIFFICULTY = 10000;

    @Getter
    private final String name;
    private int difficulty;
    private int reward;

    public int getDifficulty() {
        return ThreadLocalRandom.current().nextInt(MIN_DIFFICULTY, MAX_DIFFICULTY);
    }

    public int calculateReward() {
        return ThreadLocalRandom.current().nextInt(MIN_REWARD, MAX_REWARD);
    }
}
