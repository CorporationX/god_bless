package faang.school.godbless.bjs2_18624;

import lombok.Getter;
import lombok.Setter;

import static faang.school.godbless.bjs2_18624.Constants.DEFAULT_HEALTH_VALUE;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intelligence;
    protected int health;

    protected Character(String name) {
        this.name = name;
        this.health = DEFAULT_HEALTH_VALUE;
    }

    protected Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH_VALUE;
    }

    protected abstract void attack(Character opponent);

    protected void reduceHealth(int value) {
        health = health - value;
    }
}
