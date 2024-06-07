package faang.school.godbless.BJS27979.Creatures;

import lombok.Data;

@Data
public abstract class Creature {
    protected String name;
    protected int level;
    protected int health;
    protected int attack;
    protected int defense;
    protected int speed;
    protected int price;
    protected int quantity;
    protected int totalHealth;

    protected int getDamage() {
        return attack * quantity;
    }

    public Creature(int level, int health, int attack, int defense, int speed, int price, int quantity) {
        name = getClass().getSimpleName();
        this.level = level;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.price = price;
        this.quantity = quantity;
        totalHealth = health * quantity;
    }

    public void refreshTotalHealth() {
        totalHealth = health * quantity;
    }
}
