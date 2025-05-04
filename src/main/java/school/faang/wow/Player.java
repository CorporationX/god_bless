package school.faang.wow;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class Player {
    private static final int EXPERIENCE_TO_UPDATE_LVL = 500;

    private final String name;
    private final AtomicInteger level;
    private final AtomicInteger experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = new AtomicInteger(level);
        this.experience = new AtomicInteger(experience);
    }

    public void addExperience(int experience) {
        log.info("Присвоение игроку опыта {}", experience);
        this.experience.addAndGet(experience);
        if (this.experience.get() > EXPERIENCE_TO_UPDATE_LVL * level.get()) {
            level.incrementAndGet();
        }
    }
}