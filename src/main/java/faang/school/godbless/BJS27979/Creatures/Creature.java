package faang.school.godbless.BJS27979.Creatures;

import faang.school.godbless.BJS27979.Hero;
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
    protected int totalHealth;
    protected int quantity;
    protected Hero owner;

    public int getDamage() {
        return attack * quantity;
    }

    public void takeDamage(int damage) {
        totalHealth = Math.max(totalHealth - getFinalDamage(damage), 0);
        quantity = totalHealth / health;
        if (totalHealth % health != 0) {
            quantity++;
        }
    }

    public boolean canTakeDamage(int damage) {
        return totalHealth >= getFinalDamage(damage);
    }

    private int getFinalDamage(int damage) {
        return Math.max(damage - quantity * defense, 0);
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

    public void addTotalHealthByQuantity(int quantity) {
        totalHealth += quantity * health;
    }


}
