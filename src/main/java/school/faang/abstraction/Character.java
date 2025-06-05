package school.faang.abstraction;

import lombok.ToString;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public abstract class Character {

    protected String name;
    protected Integer strength;
    protected Integer agility;
    protected Integer intelligence;
    protected Integer health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
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
