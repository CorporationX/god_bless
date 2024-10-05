package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Character {
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intellect;
    protected int health;

    public Character(String name) {
        this(name, 0, 0, 0, 100);

    }

    public Character(String name, int strength, int dexterity, int intellect, int health) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intellect = intellect;
        this.health = 100;
    }


    public abstract void attack(Character target);
}
