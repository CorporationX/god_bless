package school.faang.bjs2_82202;

import lombok.Getter;

@Getter
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;

    public Quest(String name, QuestType questType) {
        this.name = name;
        this.difficulty = questType.getDifficulty();
        this.reward = questType.randomReward();
    }
}
