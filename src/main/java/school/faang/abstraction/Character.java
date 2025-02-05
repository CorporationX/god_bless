package school.faang.abstraction;

import lombok.Getter;

@Getter
public abstract class Character {

    private static final int BASE_SKILL_LEVEL = 5;
    private static final int BASE_HEALTH_LEVEL = 100;
    private static final int MIN_HEALTH_LEVEL = 0;

    private final String name;
    private final int power;
    private final int dexterity;
    private final int intelligence;
    private int health;

    public Character(String name) {
        this(name, BASE_SKILL_LEVEL, BASE_HEALTH_LEVEL, BASE_SKILL_LEVEL);
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = BASE_HEALTH_LEVEL;
    }

    protected abstract void attack(Character opponent);

    protected void reduceHealth(int damage) {
        health = Math.max(health - damage, MIN_HEALTH_LEVEL);
        if (health == MIN_HEALTH_LEVEL) {
            System.out.println(name + " has been killed! Happy murder day!");
        }
    }
}
