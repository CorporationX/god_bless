package school.faang.bjs2_92585;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private int level;
    private AtomicInteger experience;

    public Player addExperience(int difficulty) {
        this.experience.getAndAdd(difficulty);
        return this;
    }
}
