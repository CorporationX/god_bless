package school.faang.bjs2_79203_abstraction;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = DEFAULT_HEALTH;

    protected static final int DEFAULT_STRENGTH = 5;
    protected static final int DEFAULT_AGILITY = 5;
    protected static final int DEFAULT_INTELLIGENCE = 5;
    protected static final int DEFAULT_HEALTH = 100;

    @SuppressWarnings("unused")
    public Character(String name) {
        this(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    @Override
    public String toString() {
        return String.format(
                "Character '%s' (HP: %d, Strength: %d, Agility: %d, Intelligence: %d)",
                name, health, strength, agility, intelligence
        );
    }
}