package school.faang.abstraction;

import lombok.ToString;

@ToString
public abstract class Character {
    protected String name;
    protected Integer strength;
    protected Integer agility;
    protected Integer intelligence;
    protected Integer hitPoints = 100;

    public Character(String name) {
        this.name = name;
        strength = 5;
        agility = 5;
        intelligence = 5;
    }

    public Character(String name, Integer strength, Integer agility, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected void checkHitPointsBeforeAttack(Character character, int damage) {
        if (character.hitPoints - damage <= 0) {
            throw new IllegalArgumentException("character " + character.name + " cannot have hp below zero");
        }
    }

    abstract void attack(Character opponent);
}
