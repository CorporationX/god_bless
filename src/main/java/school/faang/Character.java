package school.faang;

import lombok.Data;

@Data
public abstract class Character {
    public static final int DEFAULT_HEALTH = 100;
    public static final int DEFAULT_STRENGTH = 5;
    public static final int DEFAULT_DEXTERITY = 5;
    public static final int DEFAULT_INTELLIGENCE = 5;

    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int health = DEFAULT_HEALTH;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_STRENGTH;
        this.dexterity = DEFAULT_DEXTERITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void attack(Character opponent) {

    }
}
