package faang.school.godbless.BJS27979.Creatures;

import faang.school.godbless.BJS27979.Hero;
import lombok.Data;

@Data
public abstract class Creature {
    protected String name;
    protected int level;
    protected int health;
    protected int attack;
    protected int baseAttack;
    protected int defense;
    protected int speed;
    protected int price;
    protected int totalHealth;
    protected int quantity;
    protected Hero owner;

    public void takeDamage(Creature attacker) {
        totalHealth = Math.max(totalHealth - countFinalTakeDamage(attacker), 0);
        quantity = totalHealth / health;
        if (totalHealth != 0 && quantity != 0) {
            quantity++;
        }
    }

    public int canTakeDamage(Creature creature) {
        return Math.min(totalHealth, countFinalTakeDamage(creature));
    }

    private double getAttackDefenseModifier(Creature creature) {
        if (creature.attack >= defense) {
            return 1 + (creature.attack - defense) * 0.05;
        } else {
            return 1 / (1 + (defense - creature.attack) * 0.05);
        }
    }

    private int countFinalTakeDamage(Creature attacker) {
        if (quantity == 0) {
            return 0;
        }
        return (int) (attacker.getBaseAttack() * getAttackDefenseModifier(attacker) * attacker.getQuantity());
    }

    public Creature(int level, int health, int attack, int baseAttack, int defense, int speed, int price, int quantity) {
        name = getClass().getSimpleName();
        this.level = level;
        this.health = health;
        this.baseAttack = baseAttack;
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
