package school.faang.bjs2_94449;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    String name;
    int level;
    int experience;

    public void addExperience(int increasingValue) {
        this.experience += increasingValue;
    }
}
