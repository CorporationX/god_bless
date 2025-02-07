package school.faang.task_56473;

import lombok.*;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    private static final int DEFAULT_STRENGTH = 5;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 5;
    private static final int DEFAULT_HEALTH = 100;
    private static final int ZERO_HEALTH = 0;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
        this.health = DEFAULT_HEALTH;

    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Character target);

    public boolean isAlive(int health) {
        return health > ZERO_HEALTH;
    }

    public void healthLevelCheck(Character opponent) {
        if (opponent.getHealth() < ZERO_HEALTH) {
            opponent.setHealth(ZERO_HEALTH);
        }
    }
}


