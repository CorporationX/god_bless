package com.basic.abstr;

public class Archer extends Character {
    private final int power = 3;
    private final int agility = 10;
    private final int intelligence = 5;

    public Archer(String name) {
        super(name);
    }

    public Archer(String name, int power, int agility, int intelligence) {
        super(name, power, agility, intelligence);
    }



    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - agility);
    }
}
