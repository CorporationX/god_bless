package school.faang.task_43924;

import lombok.Data;

@Data
public abstract class Character {

    protected String name;
    protected int power;
    protected int agility;
    protected int intelligence;
    protected int healthPoint = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(int power, int agility, int intelligence) {
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    abstract void attack(Character character);
}
