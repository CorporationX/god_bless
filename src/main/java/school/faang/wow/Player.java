package school.faang.wow;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Player {
    private final String name;
    private final int level;

    @Getter(AccessLevel.NONE)
    private final AtomicInteger experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = new AtomicInteger(experience);
    }

    void gainExperience(int reward) {
        experience.addAndGet(reward);
    }

    public int getExperience() {
        return experience.get();
    }
}
