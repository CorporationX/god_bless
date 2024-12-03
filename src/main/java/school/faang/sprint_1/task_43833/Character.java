package school.faang.sprint_1.task_43833;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int force;
    protected int agility;
    protected int intelligence;
    protected final int HEALTH = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(int force, int agility, int intelligence) {
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}