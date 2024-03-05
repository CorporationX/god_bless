package faang.school.godbless.wow;

public class Player {
    private final String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public void updateExperience(Quest quest) {
        this.experience += quest.getReward();
    }

    public void updateLevel(Quest quest) {
        this.level += Math.round(quest.getDifficulty() / 4);
    }
}
