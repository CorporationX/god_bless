package ru.task_43860;

public class Warrior extends Character{
    public Warrior() {
        super(10,5, 3);
    }

    public Warrior(String name) {
        setName(name);
    }

    @Override
    public int attack(Character first) {
        return this.getHealth()- first.getStrong();
    }
}
