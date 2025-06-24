package school.faang.bjs2_82202;

import lombok.Getter;
import java.util.concurrent.ThreadLocalRandom;

public enum QuestType {
    EASY(4000, 50, 100),
    MEDIUM(7000, 100, 300),
    HARD(10000, 300, 500);

    @Getter
    private final int difficulty;
    private final int minReward;
    private final int maxReward;

    QuestType(int difficulty, int minReward, int maxReward) {
        this.difficulty = difficulty;
        this.minReward = minReward;
        this.maxReward = maxReward;
    }

    public int randomReward() {
        return ThreadLocalRandom.current().nextInt(minReward, maxReward);
    }
}
