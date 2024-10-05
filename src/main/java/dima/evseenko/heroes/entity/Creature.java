package dima.evseenko.heroes.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class Creature implements Attacking, Cloneable {
    private final String name;
    private final int damage;
    private final int protection;
    private final int speed;

    private int level = 1;
    private int hp = 100;

    @Override
    public void takeDamage(int damage) {
        if (damage - (this.protection * level) > 0)
            this.hp -= damage - (protection * level);
    }

    @Override
    public void attack(Creature creature) {
        System.out.println(this.name + " attacked " + creature.getName());

        creature.takeDamage(this.damage * this.level);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
