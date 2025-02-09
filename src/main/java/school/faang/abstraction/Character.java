package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public abstract class Character {

    public static final int DEFAULT_VALUE = 5;

    private final String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_VALUE;
        this.agility = DEFAULT_VALUE;
        this.intelligence = DEFAULT_VALUE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    public void setHealth(int health) {
        if (health >= 0) {
            this.health = health;
            return;
        }
        System.out.println("Character " + this.getName() + " is dead!");
    }
}
