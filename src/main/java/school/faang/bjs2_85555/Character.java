package school.faang.bjs2_85555;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    public void reduceHealth(int damage) {
        int oldHealth = health;
        health = Math.max(0, health - damage);
        System.out.println(name + " получает " + damage + " урона (" + oldHealth + " → " + health + " HP)");
    }
}