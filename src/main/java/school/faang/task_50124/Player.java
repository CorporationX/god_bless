package school.faang.task_50124;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Player {
    private final String name;
    private final AtomicInteger level;
    private final AtomicInteger experience;

    public Player(String name, int level, int experience) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
        this.level = new AtomicInteger(level);
        this.experience = new AtomicInteger(experience);
    }

    public void addExperience(int experience) {
        this.experience.addAndGet(experience);
    }

    public int getExperience() {
        return experience.get();
    }

    @Override
    public String toString() {
        return String.format("Player{name=%s, level=%d, experience=%d}",
                name, level.get(), experience.get());
    }
}
