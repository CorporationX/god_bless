package school.faang.bjs2_94444;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class Player {
    private static final int LEVEL_UPGRADE = 1;
    private static final int DEFAULT_EXPERIENCE_NEXT_LEVEL = 100;
    private final String name;
    private int level;
    private AtomicInteger experience;
    private double nextLevel;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = new AtomicInteger(experience);
    }

    public Player addExperience(AtomicInteger experience) {
        this.experience.getAndAdd(experience.get());
        if (this.experience.get() >= nextLevel) {
            level += LEVEL_UPGRADE;
            log.info("{} - С повышением уровня!, теперь у вас {} лвл, так держать!", name, level);
            nextLevel = experience.get() + DEFAULT_EXPERIENCE_NEXT_LEVEL;
        }
        return this;
    }
}
