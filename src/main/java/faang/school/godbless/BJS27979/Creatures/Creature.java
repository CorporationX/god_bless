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
    protected Hero owner;

    public int getDamage() {
        return attack * owner.getArmy().get(this);

    }

    public int takeDamage(int damage, int quantityAttackers) {
        int damagePerUnit = damage / quantityAttackers - defense;
        return damagePerUnit > 0 ? damagePerUnit * quantityAttackers : 1;
    }

    public Creature(int level, int health, int attack, int defense, int speed, int price) {
        name = getClass().getSimpleName();
        this.level = level;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.price = price;
        totalHealth = health;
    }

    public void updateTotalHealth(int quantity) {
        totalHealth += health * quantity;
    }

    public boolean canTakeDamage(int damage, int quantityAttackers) {
        return totalHealth >= this.takeDamage(damage, quantityAttackers);
    }
}
