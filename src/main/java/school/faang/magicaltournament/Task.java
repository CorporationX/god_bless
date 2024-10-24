package school.faang.magicaltournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task {
    private String name;
    private int difficulty;
    private int reward;

    public int getDifficulty() {
        return difficulty;
    }

    public int getReward() {
        return reward;
    }
}
