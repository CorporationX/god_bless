package bjs2_74658;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Player {
    private String name;
    private int level;
    private AtomicInteger experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = new AtomicInteger(experience);
    }

    public int getExperience() {
        return experience.get();
    }

    public void addExperience(int experience) {
        this.experience.addAndGet(experience);
    }
}
