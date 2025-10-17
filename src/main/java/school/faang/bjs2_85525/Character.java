package school.faang.bjs2_85525;

import lombok.Getter;

@Getter
public abstract class Character {
    private String name;
    private int strength = 5;
    private int dexterity = 5;
    private int intelligence = 5;

    private static final int BASE_HEALTH = 100;
    private int health = BASE_HEALTH;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.dexterity = 5;
        this.intelligence = 5;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    abstract void attack(Character opponent);

    void takeDamage(int amount) {
        if (amount < 0) {
            amount = 0;
        }
        health = health - amount;
        if (health < 0) {
            health = 0;
        }
    }
}
