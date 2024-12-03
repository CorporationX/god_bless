package school.faang.sprint_1.task_43833;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int force;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int force, int agility, int intelligence) {
        this.name = name;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}