package school.faang.task_43804;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private static final int DEFAULT_POWER = 5;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 5;
    private static final int DEFAULT_HEALTH = 100;

    private final String name;
    private final int power;
    private final int agility;
    private final int intelligence;
    private int health;

    public Character(String name) {
        this.name = name;
        this.power = DEFAULT_POWER;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
        this.health = DEFAULT_HEALTH;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    abstract void attack(Character character);
}
