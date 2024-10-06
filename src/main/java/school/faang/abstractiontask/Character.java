package school.faang.abstractiontask;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Character {
    protected String name;
    protected int strength;
    protected int ability;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int ability, int intellect) {
        this.name = name;
        this.strength = strength;
        this.ability = ability;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);

}
