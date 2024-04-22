package faang.school.godbless.async.wow;

import lombok.Data;

@Data
public class Quest {
    private String title;
    private int difficulty;
    private int reward;

    public Quest(String name, int difficulty, int reward) {
        setTitle(name);
        setDifficulty(difficulty);
        setReward(reward);
    }

    public Quest setTitle(String title) {
        if(title == null || title.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank.");
        }

        this.title = title;
        return this;
    }

    public Quest setDifficulty(int difficulty) {
        if(difficulty < 0) {
            throw new IllegalArgumentException("Difficulty can't be lower than zero.");
        }

        this.difficulty = difficulty;
        return this;
    }

    public Quest setReward(int reward) {
        if(reward < 0) {
            throw new IllegalArgumentException("Reward can't be lower than zero.");
        }

        this.reward = reward;
        return this;
    }
}
