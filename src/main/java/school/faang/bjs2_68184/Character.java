package school.faang.bjs2_68184;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    public static final int DEFAULT_STRENGTH = 5;
    public static final int DEFAULT_AGILITY = 5;
    public static final int DEFAULT_INTELLIGENCE = 5;
    public static final int DEFAULT_HEALTH = 100;

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

    public abstract void attack(Character opponent);

    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }
}