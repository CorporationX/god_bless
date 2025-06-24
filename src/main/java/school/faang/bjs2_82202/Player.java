package school.faang.bjs2_82202;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = {"name"})
public class Player {
    @Getter
    private final String name;
    private int level;
    private int experience;
    private int maxLevelExperience;

    public Player(String name) {
        this.name = name;
        this.maxLevelExperience = 100;
    }

    public synchronized void setExperience(int experience) {
        this.experience += experience;
        while (this.experience >= maxLevelExperience) {
            level++;
            this.experience = this.experience - maxLevelExperience;
            maxLevelExperience *= 2;
        }
    }

    public synchronized int getLevel() {
        return level;
    }

    public synchronized int getExperience() {
        return experience;
    }
}
