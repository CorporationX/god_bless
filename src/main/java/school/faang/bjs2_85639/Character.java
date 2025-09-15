package school.faang.bjs2_85639;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength = 5;
    private int agility = 5;
    private int intelligence = 5;
    private byte health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    void attack(Character opponent) {}

    void recieveDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
        }
    }
}
