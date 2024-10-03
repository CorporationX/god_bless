package dima.evseenko.abstraction.entity;

import lombok.Data;

@Data
public abstract class Character implements Attacking {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health = 100;

    public Character(String name){
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
    }
}
