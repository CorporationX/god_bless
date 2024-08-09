package faang.school.godbless.javacore.abstraction;

import lombok.Getter;

public abstract class Character {

    public static final int DEFAULT_HEALTH_VALUE = 100;

    protected int strength;
    protected int agility;
    private String name;
    private int intelligence;
    @Getter
    protected int health;
    protected int damage;

    protected Character(String name) {
        this.name = name;
        this.health = DEFAULT_HEALTH_VALUE;
    }

    protected Character(String name, int strength, int agility, int intelligence, int damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH_VALUE;
        this.damage = damage;
    }

    public void checkHealth() {
        if (health <= 0) {
            System.out.println(name + " has died.");
        }
    }

    public abstract void attack(Character opponent);
}
