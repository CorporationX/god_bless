package school.faang.bjs2_79163;

import lombok.Data;

@Data
public abstract class Character {
    protected String name;
    protected int strength = 5;
    protected int agility = 5;
    protected int intelligence = 5;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
    }

    public void reduceHealth(int damage) {
        if (health <= 0) {
            System.out.println("Противник уже повержен");
            return;
        }

        health -= damage;

        if (health <= 0) {
            health = 0;
            System.out.println("Противник повержен");
        }
    }

    public abstract void attack(Character defender);
}
