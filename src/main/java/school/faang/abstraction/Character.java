package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intellect;
    private int health;

    public Character(String name) {
        this(name, 0, 0, 0);


    }

    public Character(String name, int strength, int dexterity, int intellect) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intellect = intellect;
        this.health= 100;

    }


    public abstract void attack(Character target);
}
