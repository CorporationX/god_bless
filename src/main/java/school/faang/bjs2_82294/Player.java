package school.faang.bjs2_82294;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private int level;
    private int experience;

    private static final int EXPERIENCE_OF_NEXT_LEVEL = 100;

    private void newLevel() {
        level++;
    }

    public void addExperience(int newExperience) {
        experience += newExperience;
        while (experience >= EXPERIENCE_OF_NEXT_LEVEL) {
            newLevel();
            experience -= EXPERIENCE_OF_NEXT_LEVEL;
        }
    }
}
