package school.faang.javacore.abstraction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {

    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health = 100;

    public static final int DEFAULT_STRENGTH = 5;
    public static final int DEFAULT_DEXTERITY = 5;
    public static final int DEFAULT_INTELLIGENCE = 5;

    protected Character(String name) {
        this.name = name;
        this.strength = DEFAULT_STRENGTH;
        this.dexterity = DEFAULT_DEXTERITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }

    protected Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    abstract void attack(Character opponent);
}
