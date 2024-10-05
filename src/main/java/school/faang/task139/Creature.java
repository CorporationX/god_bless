package school.faang.task139;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public abstract class Creature {

    private String name;
    private int level;
    private int damage;
    private int armor;
    private int speed;

    public Creature(String name, int level, int damage, int armor, int speed) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.armor = armor;
        this.speed = speed;
    }

    public int getAttackDamage() {
        return damage * level * speed;
    }

    public int getResistance(int damage) {
        return armor % 2 * speed <= damage ? damage - armor % 2 * speed : 1;
    }
}
