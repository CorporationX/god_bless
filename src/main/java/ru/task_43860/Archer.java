package ru.task_43860;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int newHealth = character.getHealth() - this.getDexterity();
        character.setHealth(newHealth);
    }
}

