package school.faangSprint4.t04;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public void addExperience(int experience) {
        this.experience += experience;
    }
}