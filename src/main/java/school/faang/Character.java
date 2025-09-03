package school.faang;

import lombok.Getter;
import lombok.Setter;

abstract class Character {

    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    private int health = 100;

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.dexterity = 5;
        this.intelligence = 5;
    }

    protected void receiveDamage(int damage) {
        if (damage > 0) {
            this.health -= damage;
        } else {
            this.health = 0;
            System.out.println(name + " is dead and cannot act");
        }
    }

    public abstract void attack(Character character);
}
