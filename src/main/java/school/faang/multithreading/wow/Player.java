package school.faang.multithreading.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private int level;
    private int experience;

    public void updateExperience(int exp) {
        experience += exp;
    }
}
