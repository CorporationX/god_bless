package faang.school.godbless.bjs2_18959.creatures;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static faang.school.godbless.bjs2_18959.Constants.DEFAULT_HEALTH;
import static faang.school.godbless.bjs2_18959.Constants.MIN_DAMAGE_VALUE;

@Getter
@Setter
@ToString
public abstract class Creature {
    protected String name;
    protected int price;
    protected int health;
    protected int power;
    protected int defence;
    protected int speed;

    protected Creature(String name) {
        this.name = name;
    }

    protected Creature(int price, int power, int defence, int speed) {
        this.price = price;
        this.power = power;
        this.defence = defence;
        this.speed = speed;
        this.health = DEFAULT_HEALTH;
    }

    public void attack(Creature defender) {
        var speedCoefficient = calculateSpeedCoefficient(defender);
        int damage = (int) ((double) power * (double) speedCoefficient);
        defender.acceptAttack(damage);
    }

    private double calculateSpeedCoefficient(Creature defender) {
        var defenderSpeed = defender.getSpeed();
        return (double) ((double) speed / (double) defenderSpeed);
    }

    public void acceptAttack(int damage) {
        int decreaseValue;
        if (defence >= damage) {
            decreaseValue = MIN_DAMAGE_VALUE;
        } else {
            decreaseValue = damage - defence;
        }

        decreaseHealth(decreaseValue);
    }

    public void decreaseHealth(int value) {
        health = health - value;
    }

    public boolean isDead() {
        return health <= 0;
    }
}
