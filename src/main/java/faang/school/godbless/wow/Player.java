package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Player {
    private final int LEVEL_UP_SCALE = 500;
    private String name;
    private int level;
    private int experience;

    public synchronized void increaseExperienceBy(int additionalExperience) {
        int totalExperience = experience + additionalExperience;

        int levelUp = totalExperience / LEVEL_UP_SCALE;
        int remainingExperience = totalExperience % LEVEL_UP_SCALE;

        level += levelUp;
        log.info(name + " has increased his level by " + levelUp);
        experience = remainingExperience;
    }
}
