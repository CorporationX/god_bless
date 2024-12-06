package school.faang.sprint_1.task_abstractionbsj2n43974;

import lombok.Getter;

@Getter
public abstract class Character {
    protected final int max_health = 100;
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = max_health;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int intellect) {
        this.name = name;
        this.strength = power;
        this.agility = dexterity;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);
}
