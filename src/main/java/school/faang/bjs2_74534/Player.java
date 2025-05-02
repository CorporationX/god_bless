package school.faang.bjs2_74534;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private final Integer level;
    private final AtomicInteger experience;

    public Player(String name, Integer level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = new AtomicInteger(experience);
    }

    public Player addExperience(Integer delta) {
        this.experience.addAndGet(delta);
        return this;
    }
}
