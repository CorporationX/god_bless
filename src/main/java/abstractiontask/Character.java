package abstractiontask;

import lombok.Getter;
import lombok.Setter;

public abstract class Character {
    protected String name;
    @Getter
    protected int strength;
    @Getter
    protected int dexterity;
    protected int intelligence;
    @Getter
    @Setter
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
