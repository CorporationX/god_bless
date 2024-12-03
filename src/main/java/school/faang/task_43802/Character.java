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

    public Character(String name) {
        this.name = name;
    }

    public Character(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected abstract void attack(Character character);
}
