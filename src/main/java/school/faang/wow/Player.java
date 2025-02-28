package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {

    private final String name;
    private int level;
    private int experience;

    public void addExperience(int addition) {
        experience += addition;
    }
}
