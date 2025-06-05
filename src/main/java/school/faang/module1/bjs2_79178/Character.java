package school.faang.module1.bjs2_79178;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public abstract class Character {

    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    private static final int DEFAULT_STRENGTH = 5;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void takeDamage(int damage) {
        health = Math.max(0, health - damage);
        log.info("{} получил урон равный {}", name, damage);
    }
}
