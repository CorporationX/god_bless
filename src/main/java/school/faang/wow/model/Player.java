package school.faang.wow.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Player {
    private final String name;
    private final AtomicInteger level;
    private final AtomicInteger experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = new AtomicInteger(level);
        this.experience = new AtomicInteger(experience);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level.get();
    }

    public int getExperience() {
        return experience.get();
    }

    public void addLevel(int level) {
        this.level.addAndGet(level);
    }

    public void addExperience(int experience) {
        this.experience.addAndGet(experience);
    }
}
