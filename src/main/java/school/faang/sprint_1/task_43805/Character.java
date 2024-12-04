package school.faang.sprint_1.task_43805;

import lombok.Getter;

public abstract class Character {

    private static final int DEFAULT_HEALTH = 100;
    @Getter
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intelligence;
    @Getter
    protected int health;

    public Character(String name) {
        this.name = name;
        this.health = DEFAULT_HEALTH;
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Character character);

    public void damage(int damage) {
        this.health = this.health - damage;
    }
}
