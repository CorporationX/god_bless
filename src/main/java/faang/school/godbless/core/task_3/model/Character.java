package faang.school.godbless.core.task_3.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Character {
    protected int health = 100;

    protected final String name;
    protected int power;
    protected int agility;
    protected int intelligence;

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character character);
}