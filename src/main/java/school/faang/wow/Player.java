package school.faang.wow;

import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class Player {

    private String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public void increaseExperience(int reward) {
        experience += reward;
    }
}
