package school.faang.bjs2_74534;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private final Integer level;
    private Integer experience;

    public synchronized Player addExperience(Integer delta) {
        this.experience += delta;
        return this;
    }
}
