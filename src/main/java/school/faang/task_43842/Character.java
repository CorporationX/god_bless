package school.faang.task_43842;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private static final int INIT_HEALTH = 100;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = INIT_HEALTH;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character target);

    @Override
    public String toString() {
        return getName() + " has health: " + getHealth();
    }
}
