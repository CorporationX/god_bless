package school.faang.bjs2_82225_wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Player {
    private final String name;
    private int level;
    private AtomicInteger experience;

    public Player(@NonNull String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = new AtomicInteger(experience);
    }

    public int addExperience(int exp) {
        return this.experience.addAndGet(exp);
    }
}
