package school.faang.bjs2_74668;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Player {
    private String name;
    private Integer level;
    private AtomicInteger experience;

    public Player(String name, Integer level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = new AtomicInteger(experience);
    }


    public void addExperience(int experience) {
        this.experience.addAndGet(experience);
    }
}
