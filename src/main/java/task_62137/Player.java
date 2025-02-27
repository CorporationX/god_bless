package task_62137;

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

    public void addExperience(int difficulty) {
        int experienceToAdd = difficulty * 100;
        experience += experienceToAdd;
        log.info("{} + {} опыта", name, experienceToAdd);
        log.info("Опыт {}: {}", name, experience);
    }
}
