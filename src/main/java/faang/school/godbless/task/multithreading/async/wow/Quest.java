package faang.school.godbless.task.multithreading.async.wow;

import lombok.Getter;

@Getter
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;

    public Quest(String name, int difficulty, int rewardByDifficult) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = difficulty / rewardByDifficult;
    }

    @Override
    public String toString() {
        return name + ", difficulty: " + difficulty;
    }
}
