package school.faang.BJS2_62096;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.concurrent.atomic.AtomicInteger;

@Setter
@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private AtomicInteger experience = new AtomicInteger();

    public void addExperience(int amount) {
        experience.addAndGet(amount);
    }

    public int getExperience() {
        return experience.get();
    }
}