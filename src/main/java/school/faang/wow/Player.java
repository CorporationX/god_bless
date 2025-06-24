package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Setter
@Getter
public class Player {
    private String name;
    private int level;
    private AtomicInteger experience;

    public int addExperience(int reward) {
        return experience.addAndGet(reward);
    }
}
