package school.faang.abstractrpg;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;
    private static final int BASED_VALUE = 5;
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this(name, BASED_VALUE, BASED_VALUE, BASED_VALUE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Character opponent);

    protected void reduceHealth(int damage) {
        this.health = this.health - Math.min(damage, this.health);
        System.out.printf("%s\'s health is %d\n", this.name, this.health);
    }
}
