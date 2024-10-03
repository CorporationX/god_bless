package school.faang.abstraction;

import lombok.Setter;
import lombok.ToString;

@ToString
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    @Setter
    protected int health = 100;

    public Character(String name) {
        this(name, 0, 0, 0);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character target);
}
