package school.faang.bjs2_74719;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Player {
    private static final int EXPERIENCE_PER_LEVEL = 500;

    private final String name;
    private int level;
    private int experience;

    public void addExperience(int experience) {
        if (experience > 0) {
            log.info("Player {} got {} experience", name, experience);
        }
        this.experience += experience;
    }

    public void tryEarnLevels() {
        while (experience / EXPERIENCE_PER_LEVEL > 0) {
            log.info("Player {} level upped and now he has {} level", name, ++level);
            experience -= EXPERIENCE_PER_LEVEL;
        }
    }
}