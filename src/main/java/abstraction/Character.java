package abstraction;

import lombok.Data;

@Data
public abstract class Character {
    protected String name;
    protected int power;
    protected int agility;
    protected int intelligence;
    protected int health;

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public abstract void attack(Character enemy);
}
