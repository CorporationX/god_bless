package school.faang.task_43802;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int healthPoints = 100;
    private boolean isAlive;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence, boolean isAlive) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.isAlive = true;
    }

    public abstract void attack(Character target);
}


