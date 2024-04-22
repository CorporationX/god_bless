package faang.school.godbless.async.wow;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Player {
    private static final int LEVEL_UP_MODIFIER = 10;
    private String name;
    private int level;
    private int experience;


    public Player(String name) {
        setName(name);
        setLevel(0);
        setExperience(0);
    }

    public Player(String name, int level, int experience) {
        setName(name);
        setLevel(level);
        setExperience(experience);
    }

    public Player setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank.");
        }

        this.name = name;
        return this;
    }

    public Player setLevel(int level) {
        if (level < 0 || level < this.level) {
            throw new IllegalArgumentException("Level can't be lower than zero or lower than previous value of level.");
        }

        this.level = level;
        return this;
    }

    public Player setExperience(int experience) {
        if (experience < 0) {
            throw new IllegalArgumentException("XP points can't be lower than zero.");
        }

        this.experience = experience;
        return this;
    }

    public Player gainExperience(int experience) {
        setExperience(this.experience + experience);

        if (this.experience >= Math.pow(LEVEL_UP_MODIFIER, level)) {
            level++;
            this.experience = 0;

            log.info("Player " + name + " leveled up to " + level + " level!");
        }

        return this;
    }
}
