package school.faang.sprint4_future_async.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private AtomicInteger experience;

    public void addExperience(int experience) {
        this.experience.addAndGet(experience);
    }
}