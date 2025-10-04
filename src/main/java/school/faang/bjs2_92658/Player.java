package school.faang.bjs2_92658;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Player {

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
            log.info("New level has been reached: {}", getLevel());
        }
    }

    private double requiredExpForLevelUp(int level) {
        return (150 * Math.pow(1.8, level - 1));
    }

}
