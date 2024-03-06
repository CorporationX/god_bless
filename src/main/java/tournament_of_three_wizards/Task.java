package tournament_of_three_wizards;

class Task {
    private final String name;
    private final int difficulty;
    private final int reward;

    public Task(String name, int difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getReward() {
        return reward;
    }
}
