package school.faang.task_43842;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Character {
    private static final int DEFAULT_STRENGTH = 5;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 5;
    private static final int DEFAULT_HEALTH = 100;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = DEFAULT_HEALTH;

    public Character(String name) {
        this(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void decreaseHealth(int damage) {
        if (damage >= 0) {
            health = health - damage;
        }
    }

    public abstract void attack(Character target);

    @Override
    public String toString() {
        return getName() + " has health: " + getHealth();
    }
}
