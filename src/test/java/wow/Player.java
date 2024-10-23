package wow;

public class Player {
    private String name;
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

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int updateExperience(Quest quest) {
        if (quest.getDifficolty() < 5) {
            this.setExperience(this.getExperience() + quest.getReward());
        } else if (quest.getDifficolty() >= 5 && quest.getDifficolty() < 10) {
            this.setExperience(this.getExperience() + quest.getReward()*2);
        }
        return this.getExperience();
    }
}

