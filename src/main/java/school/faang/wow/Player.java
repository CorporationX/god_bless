package school.faang.wow;


import java.util.concurrent.atomic.AtomicInteger;

public class Player {
    private final String name;
    private final int level;
    private final AtomicInteger experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = new AtomicInteger(experience);
    }

    public String name() {
        return name;
    }

    public int level() {
        return level;
    }

    public int experience() {
        return experience.get();
    }

    public int addExperience(int amount) {
        return experience.addAndGet(amount);
    }
}