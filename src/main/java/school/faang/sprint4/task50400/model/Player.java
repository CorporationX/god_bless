package school.faang.sprint4.task50400.model;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Player {
    private final String name;
    private final int level;
    private final AtomicInteger experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = new AtomicInteger(experience);
    }

    public void addExperience(int experience) {
        this.experience.addAndGet(experience);
    }
}
