package ru.task_43860;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
       int newHealth = opponent.getHealth() - this.getStrength();
       opponent.setHealth(newHealth);
    }
}
