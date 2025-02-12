package school.faang.task_58455;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private final String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    private static final int START_STRENGTH = 5;
    private static final int START_AGILITY = 5;
    private static final int START_INTELLIGENCE = 5;

    public Character(String name) {
        this.name = name;
        this.strength = START_STRENGTH;
        this.agility = START_AGILITY;
        this.intelligence = START_INTELLIGENCE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public abstract void attack(Character opponent);
}
