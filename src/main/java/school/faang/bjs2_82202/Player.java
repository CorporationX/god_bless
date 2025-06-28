package school.faang.bjs2_82202;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(of = {"name"})
public class Player {
    @Getter
    private final String name;
    @Getter
    private final AtomicInteger level;
    private int experience;
    private int maxLevelExperience;

    public Player(String name) {
        this.name = name;
        this.maxLevelExperience = 100;
        this.level = new AtomicInteger();
    }

    public synchronized void updateExperienceAndLevel(int experience) {
        this.experience += experience;
        while (this.experience >= maxLevelExperience) {
            level.incrementAndGet();
            this.experience = this.experience - maxLevelExperience;
            maxLevelExperience *= 2;
        }
    }

    public synchronized int getExperience() {
        return experience;
    }
}
