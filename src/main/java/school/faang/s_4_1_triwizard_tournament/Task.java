package school.faang.s_4_1_triwizard_tournament;

public class Task {
    private String name;
    private int difficulty;
    private int reward;

    public Task(String name, int difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getReward() {
        return reward;
    }
}
