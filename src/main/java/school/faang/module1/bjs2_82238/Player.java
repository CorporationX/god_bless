package school.faang.module1.bjs2_82238;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private final int level;
    private AtomicInteger experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = new AtomicInteger(experience);
    }

    public void updateExperience(int reward) {
        experience.addAndGet(reward);
    }
}