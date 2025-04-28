package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Data
public class Player {
    private String name;
    private int level;
    private AtomicInteger experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = new AtomicInteger(experience);
    }

    public void updateExperience(int gainedExperience) {
        experience.addAndGet(gainedExperience);
    }
}
