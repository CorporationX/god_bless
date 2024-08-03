package abstraction;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligent;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligent) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligent = intelligent;
    }

    abstract void attack(Character enemy);
}
