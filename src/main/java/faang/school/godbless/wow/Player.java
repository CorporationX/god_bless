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

    public void addExperience(int experiencePoints){
        experience += experiencePoints;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }
}
