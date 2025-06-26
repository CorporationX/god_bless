package school.faang.bjs2_82245;

import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Player {
    private String name;
    private int level;
    private AtomicInteger experience;

    public Player(@NonNull String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = new AtomicInteger(experience);
    }

    public void gainExperience(int amount) {
        experience.addAndGet(amount);
    }
}
