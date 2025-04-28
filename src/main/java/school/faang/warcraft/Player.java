package school.faang.warcraft;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@EqualsAndHashCode
@ToString
public class Player {
    private final String name;
    private final int level;
    private final AtomicInteger experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = new AtomicInteger(experience);
    }

    public void addExperience(int amount) {
        this.experience.addAndGet(amount);
    }
}
