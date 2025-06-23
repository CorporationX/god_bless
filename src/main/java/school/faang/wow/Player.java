package school.faang.wow;

import lombok.Data;

@Data
public class Player {
    private static final int UPPER_TO_EXPERIENCE = 50;

    private final String name;
    private int lvl;
    private int experience;
    private int experienceToNextLvl;

    public Player(String name, int lvl, int experience) {
        this.name = name;
        this.lvl = lvl;
        this.experience = experience;
        this.experienceToNextLvl = lvl * UPPER_TO_EXPERIENCE;
    }

    public void lvlUp(int exp) {
        if (experience + exp > experienceToNextLvl) {
            lvl++;
            experience += (exp - experienceToNextLvl);
            experienceToNextLvl += UPPER_TO_EXPERIENCE;
        } else {
            experience += exp;
        }
    }
}