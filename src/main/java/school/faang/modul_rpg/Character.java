package school.faang.modul_rpg;

import lombok.Getter;

@Getter
abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    protected void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public abstract void attack(Character opponent);
}