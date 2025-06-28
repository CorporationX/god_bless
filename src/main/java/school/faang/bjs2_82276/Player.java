package school.faang.bjs2_82276;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Player {

    private String name;
    private int level;
    private AtomicInteger experience;

    public int addExperience(int reward) {
        return experience.addAndGet(reward);
    }
}
