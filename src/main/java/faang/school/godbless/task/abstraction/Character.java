package faang.school.godbless.task.abstraction;

import lombok.Getter;

@Getter
public abstract class Character {
    public static final int MAX_HEALTH = 100;
    public static final int MIN_CHARACTERISTIC = 0;
    public static final int MAX_STRENGTH = 10;
    public static final int MAX_AGILITY = 10;
    public static final int MAX_INTELLIGENCE = 10;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can't be blank");
        }
        if (((strength < MIN_CHARACTERISTIC) || (strength > MAX_STRENGTH))
                && ((agility < MIN_CHARACTERISTIC) || (agility > MAX_AGILITY))
                && ((intelligence < MIN_CHARACTERISTIC) || (intelligence > MAX_INTELLIGENCE))) {
            throw new IllegalArgumentException("Invalid characteristics");
        }
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = MAX_HEALTH;
    }

    public abstract void attack(Character enemy);

    protected void getDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " is dead");
            health = 0;
        }
    }
}
