package ru.task_43860;

public class Archer extends Character {
    public Archer() {
        super(3, 10, 5);
    }

    public Archer(String name) {
        super(name);
    }

    @Override
    public void attack(Character character) {
        int newHealth = character.getHealth() - this.getDexterity();
        character.setHealth(newHealth);
    }
}

