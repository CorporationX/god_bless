package school.faang.task_43878;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 0;
        this.dexterity = 0;
        this.intelligence = 0;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {    //health cannot be lower than 0
        this.health = Math.max(0, health);
    }

    public abstract void attack(Character character);
}
