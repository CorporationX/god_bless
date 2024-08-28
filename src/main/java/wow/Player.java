package wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Player {
    private static final int LEVEL_SCALE = 100;
    private final String name;
    private int level;
    private int experience;

    public void addExperience(int exp) {
        experience += exp;
        log.info(String.format("%s gained %d EP", name, exp));
        updateLevel();
    }

    private void updateLevel() {
        while (experience > level * LEVEL_SCALE) {
            experience -= level * LEVEL_SCALE;
            level++;
            log.info(String.format("%s get %d level", name, level));
        }
    }
}
