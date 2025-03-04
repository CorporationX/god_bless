package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private AtomicInteger experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = new AtomicInteger(experience);
    }

    public void addExperience(int reward) {
        this.experience.addAndGet(reward);
    }
}
