package faang.school.godbless.BJS2_13889;

public class Player{
    private String name;
    private int level;
    private int experience;

    public Player(String name , int level , int experience){
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
}
