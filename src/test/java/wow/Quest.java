package wow;

public class Quest {
    private String name;
    private int difficolty;
    private int reward;

    public Quest(String name, int difficolty, int reward) {
        this.name = name;
        this.difficolty = difficolty;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public int getDifficolty() {
        return difficolty;
    }

    public int getReward() {
        return reward;
    }
}
