package school.faang.task_43908;

import lombok.Getter;

public abstract class Character {

    @Getter
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    public void takeDamage(int damage) {
        this.health -= damage;
    }

}
