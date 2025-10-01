package school.faang.bjs294515;

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
    private AtomicInteger experience;

    public Player() {
        this.experience = new AtomicInteger(0);
    }

    public void setExperience(int experience) {
        this.experience.set(experience);
    }

    public void addExperience(int reward) {
        this.experience.addAndGet(reward);
    }
}
