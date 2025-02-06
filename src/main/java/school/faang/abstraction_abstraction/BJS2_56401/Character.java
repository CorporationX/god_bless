package school.faang.abstraction_abstraction.BJS2_56401;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
public abstract class Character {
    private static final Logger LOGGER = LoggerFactory.getLogger(Character.class);

    private static final int BASE_VALUE_OF_CHARACTERISTIC = 5;

    private final String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(@NonNull String name) {
        this.name = name;
        this.strength = BASE_VALUE_OF_CHARACTERISTIC;
        this.agility = BASE_VALUE_OF_CHARACTERISTIC;
        this.intelligence = BASE_VALUE_OF_CHARACTERISTIC;

        LOGGER.info("Character created: {}", name);
    }

    public Character(@NonNull String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;

        LOGGER.info("Character created: {}", name);
    }

    public abstract void attack(Character opponent);

    public void setHealth(int health) {
        this.health = Math.max(health, 0);

        LOGGER.info("{}'s health set to {}", name, health);
    }
}
