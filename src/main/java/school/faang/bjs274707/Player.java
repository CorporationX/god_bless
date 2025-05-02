package school.faang.bjs274707;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public void addExperience(Quest quest) {
        experience += quest.reward();
    }
}

