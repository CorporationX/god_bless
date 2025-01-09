package wow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private final String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }
}

