package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private int level;
    private AtomicInteger experience;

    protected void addExperience(int experience) {
        this.experience.addAndGet(experience);
    }

}
