package school.faang.task_43926;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private static final int POWER_CONST = 0;
    private static final int AGILITY_CONST = 0;
    private static final int INTELLIGENCE = 0;
    private static final int HEALTH_MAX = 100;

    private final String name;
    private final int power;
    private final int agility;
    private final int intelligence;
    private int health;

    public Character(String name) {
        this.name = name;
        this.health = HEALTH_MAX;
        this.intelligence = INTELLIGENCE;
        this.agility = AGILITY_CONST;
        this.power = POWER_CONST;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.health = HEALTH_MAX;
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}

