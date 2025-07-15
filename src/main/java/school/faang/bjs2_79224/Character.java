package school.faang.bjs2_79224;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = BASE_HEALTH;

    protected static final int BASE_STRENGTH = 5;
    protected static final int BASE_AGILITY = 5;
    protected static final int BASE_INTELLIGENCE = 5;
    protected static final int BASE_HEALTH = 100;

    public Character(String name) {
        this(name, BASE_STRENGTH, BASE_AGILITY, BASE_INTELLIGENCE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void giveDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean isDead() {
        return health <= 0;
    }
}
