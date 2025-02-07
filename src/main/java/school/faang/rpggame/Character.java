package school.faang.rpggame;

import lombok.Getter;

@Getter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    private static final int DEFAULT_STRENGTH = 5;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Character(String name) {
        this(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
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
