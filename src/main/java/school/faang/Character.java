package school.faang;

import lombok.Data;

@Data
public abstract class Character {
    public static final int DEFAULT_HEALTH = 100;
    public static final int DEFAULT_STRENGTH = 5;
    public static final int DEFAULT_AGILITY = 5;
    public static final int DEFAULT_INTELLIGENCE = 5;

    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = DEFAULT_HEALTH;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

}
