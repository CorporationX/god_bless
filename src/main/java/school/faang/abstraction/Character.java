package school.faang.abstraction;

import lombok.ToString;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public abstract class Character {

    private static final int DEFAULT_VALUE = 5;

    protected String name;
    protected Integer strength;
    protected Integer agility;
    protected Integer intelligence;
    protected Integer health = 100;

    public Character(String name) {
        this(name, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);
    }

    public Character(String name, Integer strength, Integer agility, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    public void decreaseHealth(Integer amount) {
        var newHealth = health - amount;
        health = Math.max(newHealth, 0);
    }

    public boolean isAlive() {
        return health > 0;
    }
}
