package school.faang.async.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private final int level;
    private AtomicInteger experience;

    public void addExperience(int reward) {
        this.experience.getAndAdd(reward);
    }
}
