package com.basic.abstr;

public class Warrior extends Character {
    private final int power = 10;
    private final int agility = 5;
    private final int intelligence = 3;

    public Warrior(String name) {
        super(name);
    }

    public Warrior(String name, int power, int agility, int intelligence) {
        super(name, power, agility, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - power);
    }
}
