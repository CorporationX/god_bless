package wow;

public class Quest {
    private String name;
    private String difficulty;
    private int reward;

    public Quest(String name, String difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getReward() {
        return reward;
    }
}
