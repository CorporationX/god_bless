package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private int level;
    private int experience;

    void addExperience(int experience) {
        this.experience += experience;
    }


}
