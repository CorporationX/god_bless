package faang.school.godbless.alexbulgakoff.abstraction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@Getter
@Setter
@ToString
public abstract class Character {

    protected String name;

    protected int power;

    protected int dexterity;

    protected int intelligence;

    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this(name);
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    abstract void attack(Character character);
}
