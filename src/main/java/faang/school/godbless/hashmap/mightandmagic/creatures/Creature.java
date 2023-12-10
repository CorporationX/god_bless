package faang.school.godbless.hashmap.mightandmagic.creatures;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(exclude = {"quantity", "overallHp"})
public abstract class Creature {

    protected final String name;
    protected final int level;
    protected final int attack;
    protected final int defense;
    protected final int speed;
    protected final int hp;
    @Setter
    protected int quantity;
    @Setter
    protected int overallHp;

    public Creature(String name, int level, int attack, int defense, int speed, int hp, int quantity) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.hp = hp;
        this.quantity = quantity;
        this.overallHp = hp * quantity;
    }

    public int getDamage() {
        return quantity * getAttack() * ((getLevel() / 10) + 1);
    }

    public void takeDamage(int damage) {
        defenceBasedModifyDamage(damage);
        overallHp -= damage;
        if (overallHp <= 0) {
            quantity = 0;
        } else {
            quantity = overallHp % hp == 0
                    ? overallHp / hp
                    : overallHp / hp + 1;
        }
    }

    private void defenceBasedModifyDamage(int damage) {
        int overallDefence = defense * quantity;
        if (overallDefence < damage) {
            damage += (damage - overallDefence) / 2;
        } else if (overallDefence > damage) {
            damage -= (overallDefence - damage) / 2;
        }
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
        overallHp += quantity * hp;
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
        overallHp -= quantity * hp;
    }

}
