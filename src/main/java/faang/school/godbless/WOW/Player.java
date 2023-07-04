package faang.school.godbless.WOW;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {

    private String name;
    private int level;
    private int experience;

    public void addExperience(int exp) {
        experience += exp;
    }
}
