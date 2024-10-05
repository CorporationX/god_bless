package Abstraction_BJS2_31397;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;


    public Character(String name) {
        this(name, 0, 0, 0);
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void damage(int damage) {
        this.health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
}