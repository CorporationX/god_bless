package school.faang.wow.model;

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

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public void addLevel(int level) {
        this.level += level;
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }
}
