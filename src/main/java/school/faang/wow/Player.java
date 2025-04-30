package school.faang.wow;

import lombok.Getter;

@Getter
public class Player {
    private static final int EXPERIENCE_TO_UPDATE_LVL = 500;

    private final String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public void setExperience(int experience) {
        this.experience = this.experience + experience;
        if (this.experience > EXPERIENCE_TO_UPDATE_LVL * level) {
            level++;
        }
    }
}