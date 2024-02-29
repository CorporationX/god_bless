package faang.school.godbless.magicians;

public class Task {
    private final String name;
    private final int difficulty;
    private final int reward;

    public String getName() {
        return name;
    }

    public int getReward() {
        return reward;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public Task(String name, int difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}
