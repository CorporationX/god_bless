package school.faang.task_43848;

import lombok.Getter;

@Getter
public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;
    private static final int MIN_HEALTH = 0;

    protected final String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    private int health = DEFAULT_HEALTH;
    private boolean alive = true;

    public Character(String name) {
        this(name, GameConfig.DEFAULT_STRENGTH, GameConfig.DEFAULT_AGILITY, GameConfig.DEFAULT_INTELLIGENCE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character defender);

    public void setHealth(int newHealth) {
        if (newHealth < MIN_HEALTH) {
            health = MIN_HEALTH;
            alive = false;
        } else {
            health = newHealth;
        }
    }
}
