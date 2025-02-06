package school.faang.rpggame;

import lombok.Getter;

@Getter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
        this.health = 100;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public abstract void attack(Character opponent);

    public boolean isDead(Character character) {
        if (character.health <= 0) {
            character.setHealth(0);
            return true;
        } else {
            return false;
        }
    }
}
