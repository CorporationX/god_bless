package faang.school.godbless.BJS2_19037;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public abstract class Creature {
    private String name;
    private int level;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private int quantity;

    public Creature(String name, int level, int health, int damage, int defense, int speed, int quantity) {
        Validator.validateNotEmpty(name, "Name");
        Validator.validatePositive(level, "Level");
        Validator.validatePositive(health, "Health");
        Validator.validateNonNegative(damage, "Damage");
        Validator.validateNonNegative(defense, "Defense");
        Validator.validateNonNegative(speed, "Speed");
        Validator.validatePositive(quantity, "Quantity");
        this.name = name;
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.quantity = quantity;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }
}
