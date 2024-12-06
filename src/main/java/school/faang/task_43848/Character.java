package school.faang.task_43848;

import lombok.Getter;

import static school.faang.task_43848.GameConfig.DEFAULT_STRENGTH;
import static school.faang.task_43848.GameConfig.DEFAULT_AGILITY;
import static school.faang.task_43848.GameConfig.DEFAULT_INTELLIGENCE;

@Getter
public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;
    private static final int MIN_HEALTH = 0;

    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = DEFAULT_HEALTH;

    public Character(String name) {
        this(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character defender);

    public boolean isAlive() {
        return health > 0;
    }

    protected void setHealth(int newHealth) {
        if (newHealth < MIN_HEALTH) {
            health = MIN_HEALTH;
        } else {
            health = newHealth;
        }
    }
}
