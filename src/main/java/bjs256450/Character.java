package bjs256450;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intellect = 5;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    protected abstract void attack(Character opponent);

    boolean isHealthNotLessThanZero(Character fighter) {
        boolean healthNotLessThanZero = true;
        if (fighter.getHealth() < 0 || fighter.getHealth() == 0) {
            fighter.setHealth(0);
            healthNotLessThanZero = false;
        }
        return healthNotLessThanZero;
    }
}