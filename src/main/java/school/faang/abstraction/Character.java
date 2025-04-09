package school.faang.abstraction;

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
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        this.name = name;
        strength = 5;
        agility = 5;
        intelligence = 5;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        if(health < 0) {
            this.health = 0;
            System.out.println("Killed");
        } else {
            this.health = health;
        }
    }

    abstract void attack(Character opponent);
}
