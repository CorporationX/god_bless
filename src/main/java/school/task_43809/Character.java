package school.task_43809;

import lombok.ToString;

@ToString
public abstract class Character {
    private final static int DEFAULT_HEALTH = 100;
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health;

    public Character(String name, int strength, int agility, int intelligence) {
        validateParams(name);
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    protected int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        if (health > 0) {
            this.health = health;
        } else {
            throw new IllegalArgumentException("Health is negative");
        }
    }

    private void validateParams(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name required parameter");
        }
    }

    public abstract void attack(Character character);
}
