package faang.school.godbless.fourth.Wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private int level;
    private int experience;

    public void upLevel() {
        level++;
        experience = 0;
    }

    public void earnExperience(int exp) {
        experience += exp;
    }
}
