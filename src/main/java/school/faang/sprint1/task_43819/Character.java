package school.faang.sprint1.task_43819;

import lombok.Getter;

@Getter
public abstract class Character {
    private final String NAME;

    private int health = 100;
    private int power;
    private int dexterity;
    private int intellect;
    private boolean isAlive = true;

    public abstract void attack(Character character);

    public void takingDamage(int damage) {
        health -= damage;
        if (health > 0) {
            return;
        }
        isAlive = false;
    }

    public Character(String name, int power, int dexterity, int intellect) {
        this.NAME = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
    }

    public Character(String name) {
        this.NAME = name;
    }
}
