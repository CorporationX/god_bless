package school.faang.bjs2_92658;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Player {

    private static final int FIRST_LEVEL_UP_EXP = 50;
    private static final double EXP_MULTIPLIER_FOR_LEVEL_UP = 1.8;

    private final String name;
    private int level;
    private int experience;

    public void addExp(int reward) {
        if (reward < 0) {
            throw new IllegalArgumentException("The experience gained cannot be negative");
        }
        experience += reward;
        log.info("Added experience {}. Current experience: {}", reward, getExperience());
        while (experience >= requiredExpForLevelUp(level + 1)) {
            level++;
            log.info("New level has been reached by {}: {}", name, getLevel());
        }
    }

    private double requiredExpForLevelUp(int level) {
        return (FIRST_LEVEL_UP_EXP * Math.pow(EXP_MULTIPLIER_FOR_LEVEL_UP, level - 1));
    }

}
