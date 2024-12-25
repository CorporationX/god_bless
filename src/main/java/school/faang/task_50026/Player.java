package school.faang.task_50026;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Player {

    private final String name;
    private int level;
    private int experience;
    private int experienceToUpLvl;

    public Player(String name, int level, int experience) {
        if (name == null || name.isEmpty()) {
            log.error("name is null or empty");
            throw new IllegalArgumentException("name is null or empty");
        }
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.experienceToUpLvl = level * 100;
    }

    private void levelUp() {
        this.experience -= this.experienceToUpLvl;
        this.level++;
        this.experienceToUpLvl = level * 100;
        log.info("{} Воу! Воу! Ты апнул лвл! Ваш лвл: {}", name, this.level);
    }

    public void addExperience(int experience) {
        this.experience += experience;
        while (this.experience >= this.experienceToUpLvl) {
            levelUp();
        }
    }
}