package school.faang.sprint1.task_BJS2_56346;

import lombok.Getter;

@Getter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    protected Character(String name, int strength,
                        int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public abstract void attack(Character opponent);
}
