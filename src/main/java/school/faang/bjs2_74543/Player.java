package school.faang.bjs2_74543;

import lombok.Data;

@Data
public class Player {

    private final String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public synchronized Player updatePlayerExperience(int reward) {
        experience += reward;
        return this;
    }
}
