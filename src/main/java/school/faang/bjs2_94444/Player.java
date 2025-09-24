package school.faang.bjs2_94444;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Player {
    private static final int LEVEL_UPGRADE = 1;
    private static final int DEFAULT_EXPERIENCE_NEXT_LEVEL = 100;
    private final String name;
    private int level;
    private double experience;
    private double nextLevel;

    public Player(String name, int level, double experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public Player addExperience(double experience) {
        this.experience += experience;
        if (this.experience >= nextLevel) {
            level += LEVEL_UPGRADE;
            log.info("{} - С повышением уровня!, теперь у вас {} лвл, так держать!", name, level);
            nextLevel = experience + DEFAULT_EXPERIENCE_NEXT_LEVEL;
        }
        return this;
    }
}
