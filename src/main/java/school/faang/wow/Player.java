package school.faang.wow;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Player {
    private String name;
    private int level;
    private AtomicInteger experience = new AtomicInteger();

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience.set(experience);
    }

    public void addExperience(int exp) {
        experience.addAndGet(exp);
    }
}
