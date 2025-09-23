package school.faang.sprint1.abstraaction;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
abstract class Character {

    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    /**
     * Constructor for vanilla all-rounded character with default settings.
     *
     * @param name name of character
     */
    public Character(String name) {
        this(name, 5, 5, 5);
    }

    /**
     * Constructor for character with custom settings.
     *
     * @param name         name of character
     * @param strength     strength of character
     * @param agility      agility of character
     * @param intelligence intelligence of character
     */
    protected Character(String name, int strength, int agility, int intelligence) {
        Objects.requireNonNull(name);
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public abstract void attack(Character opponent);

    protected void applyDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }


}
