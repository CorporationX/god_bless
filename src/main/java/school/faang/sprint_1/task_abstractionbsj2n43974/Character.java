package school.faang.sprint_1.task_abstractionbsj2n43974;

import lombok.Getter;

@Getter
public abstract class Character {
    protected static final int maxHealth = 100;
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = maxHealth;

    public Character() {}

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);
}
