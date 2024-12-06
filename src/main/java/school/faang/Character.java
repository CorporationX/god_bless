package school.faang;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this(name, 0, 0, 0);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Character target);
}
