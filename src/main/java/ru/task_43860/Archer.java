package ru.task_43860;

public class Archer extends Character{
    public Archer() {
        super(3,10, 5);
    }

    public Archer(String name) {
        setName(name);
    }

    @Override
    public int attack(Character first) {
        return this.getHealth()- first.getDexterity();
    }
}

