package school.faang;

import lombok.Getter;

public abstract class Character {

    private final String name;
    @Getter
    private final int strength;
    @Getter
    private final int agility;
    private final int intelligence;
    protected int health = 100;

    public Character(String name) {

        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public Character(int strength, int agility, int intelligence, String name) {
        this.intelligence = intelligence;
        this.agility = agility;
        this.strength = strength;
        this.name = name;
    }

    public abstract void attack(Character opponent);

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
}
