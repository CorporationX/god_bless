package school.faang.task_56456;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private static final int BASIC_VALUE = 5;
    private static final int DEFAULT_HEALTH_VALUE = 100;
    private static final int MINIMUM_HEALTH_VALUE = 0;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = DEFAULT_HEALTH_VALUE;

    public Character(String name) {
        this.name = name;
        strength = BASIC_VALUE;
        agility = BASIC_VALUE;
        intelligence = BASIC_VALUE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void checkNegativeHealth() {
        if (getHealth() < MINIMUM_HEALTH_VALUE) {
            setHealth(MINIMUM_HEALTH_VALUE);
        }
    }
}
