package school.faang.wow;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter

public class Player {
    public static final Logger logger = LoggerFactory.getLogger(Player.class);
    private String name;
    private int level;
    private int experience;

    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public synchronized void addExperience(int experience) {
        this.experience += experience;
        if (this.experience >= level * 100) {
            this.experience -= level * 100;
            this.level++;
            logger.info("{} повысил уровень до {} !", name, level);
        }
    }

    @Override
    public String toString() {
        return "Игрок " + name + " | Уровень: " + level + " | Опыт: " + experience;
    }
}