package faang.school.godbless.bs2_25071;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public Player increaseExperienceAndGet(int value) {
        experience += value;
        return this;
    }
}
