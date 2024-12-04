package school.faang.sprint1.task_43819;

import lombok.Getter;

@Getter
public abstract class Character {
    private final String name;

    private int health = 100;
    private int power;
    private int dexterity;
    private int intellect;

    public boolean isAlive() {
        return health > 0;
    }

    public abstract void attack(Character character);

    public void takingDamage(int damage) {
        health = Math.max(health - damage, 0);
    }

    public Character(String name, int power, int dexterity, int intellect) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intellect = intellect;
    }

    public Character(String name) {
        this.name = name;
    }
}
