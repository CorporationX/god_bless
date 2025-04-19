package school.faang.abstraction_abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private static final int HEALTH = 100;
    private int currentHealth;

    protected Character(String name) {
        this(name, CharacterConfig.BASE_STAT, CharacterConfig.BASE_STAT, CharacterConfig.BASE_STAT);
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.currentHealth = HEALTH;
    }

    public abstract void attack(Character opponent);

    public void updateHealth(int damage) {
        this.currentHealth = Math.max(currentHealth - damage, 0);
    }
}