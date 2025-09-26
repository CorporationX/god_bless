package school.faang.bjs2_92608;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public void increaseExperience(int experience) {
        this.experience += experience;
    }
}
